package com.tensorflow;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.tensorflow.Output;
import org.tensorflow.TensorFlow;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import com.tensorflow.LabelImage.GraphBuilder;


public class HelloWorld {

	 private static final String MODEL_FILE = "D:\\fangyue\\桌面20170701\\tensorflow-android-java\\model\\matrix.pb"; //模型存放路径

	    //数据的维度
	    private static final int HEIGHT = 1;
	    private static final int WIDTH = 2;

	    //模型中输出变量的名称
	    private static final String inputName = "input";
	    //用于存储的模型输入数据
	    private float[] inputs = new float[HEIGHT * WIDTH];

	    //模型中输出变量的名称
	    private static final String outputName = "output";
	    //用于存储模型的输出数据
	    private float[] outputs = new float[HEIGHT * WIDTH];


	    static byte[] graphDef = readAllBytesOrExit(Paths.get(MODEL_FILE));

	    public static Tensor getTensor(float[] a,String inputName,int width,int height){
	    	Graph g = new Graph();
	    	GraphBuilder b = new GraphBuilder(g);
	    	//Output input = b.constant(inputName, a);
	    	FloatBuffer fa = FloatBuffer.wrap(a);
	    	
//	    	Output output = b.constant(inputName, Tensor.create(new long []{width,height}, fa));
//	    	//Output output = b.resizeBilinear(input, b.constant("size", new int[] {width, height}));
//	    	Session s = new Session(g);
//	    	return s.runner().fetch(output.op().name()).run().get(0);
	    	return Tensor.create(new long []{width,height}, fa);
	    }
	    public static float[] getAddResult(Tensor a, Tensor b,int resultlength) {
	    	Graph g = new Graph();
	    	g.importGraphDef(graphDef);
	    	Session s = new Session(g);
	    	Tensor result = s.runner().feed("input1", a).feed("input2",b).fetch("output").run().get(0);
	    	
	    	float[] aa=new float[resultlength];
	    	FloatBuffer fa = FloatBuffer.wrap(aa);
	    	result.writeTo(fa);
	    	//return result.copyTo(new float[0][4])[0];
	    	return aa;

	    }
	
	public static void main(String[] args) {
		float [] x=new float[36];
		for(int i=0;i<36;i++){
			x[i]=(float)Math.random()*100;
		}
		float []result =getAddResult(getTensor(x,"input1",9,4),getTensor(x,"input2",4,9),81);
		for(float x1:result){
			System.out.println(x1);
		}
		

	}
	
	  private static byte[] readAllBytesOrExit(Path path) {
		    try {
		      return Files.readAllBytes(path);
		    } catch (IOException e) {
		      System.err.println("Failed to read [" + path + "]: " + e.getMessage());
		      System.exit(1);
		    }
		    return null;
		  }


}

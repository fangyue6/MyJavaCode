package com.algorithm;

/**
 * 实现模拟退火算法
 */
public class SATest {
    public static final int T = 100;// 初始化温度
    public static final double Tmin = 1e-8;// 温度的下界
    public static final int k = 100;// 迭代的次数
    public static final double delta = 0.98;// 温度的下降率

    public static double getX() {
        return Math.random() * 100;
    }

    /**
     * 求得函数的值
     * 
     * @param x目标函数中的一个参数
     * @param y目标函数中的另一个参数
     * @return函数值
     */
    public static double getFuncResult(double x, double y) {
        double result = 6 * Math.pow(x, 7) + 8 * Math.pow(x, 6) + 7
                * Math.pow(x, 3) + 5 * Math.pow(x, 2) - x * y;

        return result;
    }

    /**
     * 模拟退火算法的过程
     * @param y目标函数中的一个参数
     * @return最优解
     */
    public static double getSA(double y) {
        double result = Double.MAX_VALUE;// 初始化最终的结果
        double t = T;
        double x[] = new double[k];
        // 初始化初始解
        for (int i = 0; i < k; i++) {
            x[i] = getX();
        }
        // 迭代的过程
        while (t > Tmin) {
            for (int i = 0; i < k; i++) {
                // 计算此时的函数结果
                double funTmp = getFuncResult(x[i], y);
                // 在邻域内产生新的解
                double x_new = x[i] + (Math.random() * 2 - 1) * t;
                // 判断新的x不能超出界
                if (x_new >= 0 && x_new <= 100) {
                    double funTmp_new = getFuncResult(x_new, y);
                    if (funTmp_new - funTmp < 0) {
                        // 替换
                        x[i] = x_new;
                    } else {
                        // 以概率替换
                        double p = 1 / (1 + Math
                                .exp(-(funTmp_new - funTmp) / T));
                        if (Math.random() < p) {
                            x[i] = x_new;
                        }
                    }
                }
            }
            t = t * delta;
        }
        int temp_i = 0;
        double temp_result = 0;
        for (int i = 0; i < k; i++) {
        	temp_result = getFuncResult(x[i], y);
        	if(result > temp_result ){
        		temp_i = i;
        		result = temp_result;
        	}
            //result = Math.min(result, getFuncResult(x[i], y));
        }
        System.out.println("获得最优解的x为：" + x[temp_i]);
        return result;
    }

    public static void main(String args[]) {
        // 设置y的值
        int y = 0;
        System.out.println("最优解为：" + getSA(y));
       // System.out.println("最优解为：" + getSA(y));
        //System.out.println(getFuncResult(4.326039692231521, 0));
    }

}
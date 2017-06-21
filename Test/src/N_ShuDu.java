import java.util.Arrays;


public class N_ShuDu {
	// 9*9数独题目  
	String[][] resultArray = new String[][] {  
	    {  
	        "0", "2", "0", "0", "0", "0", "0", "0", "0"  
	    }, {  
	        "5", "0", "6", "0", "0", "0", "3", "0", "9"  
	    }, {  
	        "0", "8", "0", "5", "0", "2", "0", "6", "0"  
	    }, {  
	        "0", "0", "5", "0", "7", "0", "1", "0", "0"  
	    }, {  
	        "0", "0", "0", "2", "0", "8", "0", "0", "0"  
	    }, {  
	        "0", "0", "4", "0", "1", "0", "8", "0", "0"  
	    }, {  
	        "0", "5", "0", "8", "0", "7", "0", "3", "0"  
	    }, {  
	        "7", "0", "2", "0", "0", "0", "4", "0", "5"  
	    }, {  
	        "0", "4", "0", "0", "0", "0", "0", "7", "0"  
	    }  
	};  
	
	
	
	/** 
	 * 行校验 
	 * @param resultArray 
	 * @param row 
	 * @param value 
	 * @return 
	 */  
	private static boolean checkRow(final String[][] resultArray, int row, String value) {  
	    int arrayLen = resultArray.length;  
	    for (int i = 0; i < arrayLen; i++) {  
	        if (value.equals(resultArray[row][i])) {  
	            return false;  
	        }  
	    }  
	    return true;  
	}  
	
	/** 
	 * 列校验 
	 * @param resultArray 
	 * @param col 
	 * @param value 
	 * @return 
	 */  
	private static boolean checkColumn(final String[][] resultArray, int col, String value) {  
	    int arrayLen = resultArray.length;  
	    for (int i = 0; i < arrayLen; i++) {  
	        if (value.equals(resultArray[i][col])) {  
	            return false;  
	        }  
	    }  
	    return true;  
	}  
	
	
	/** 
	 * 宫校验 
	 * @param resultArray 
	 * @param row 
	 * @param col 
	 * @param value 
	 * @return 
	 */  
	private static boolean checkBlock(final String[][] resultArray, int row, int col, String value) {  
	    int arrayLen = resultArray.length;  
	    int blockLen = (int) Math.sqrt(arrayLen);  
	    int blockRowIndex = (int) row / blockLen;  
	    int blockColIndex = (int) col / blockLen;  
	    int blockRowStart = blockLen * blockRowIndex;  
	    int blockColStart = blockLen * blockColIndex;  
	  
	    for (int i = 0; i < blockLen; i++) {  
	        int rowIndex = blockRowStart + i;  
	        for (int j = 0; j < blockLen; j++) {  
	            int colIndex = blockColStart + j;  
	            if (value.equals(resultArray[rowIndex][colIndex])) {  
	                return false;  
	            }  
	        }  
	    }  
	    return true;  
	}  
	
	/** 
	 * 对角线校验（左上至右下） 
	 * @param resultArray 
	 * @param value 
	 * @return 
	 */  
	private static boolean checkLeftTop2RightBottom(final String[][] resultArray, int row, int col, String value) {  
	    if (row == col) {  
	        int arrayLen = resultArray.length;  
	        for (int i = 0; i < arrayLen; i++) {  
	            if (value.equals(resultArray[i][i])) {  
	                return false;  
	            }  
	        }  
	    }  
	    return true;  
	}  
	
	/** 
	 * 对角线校验（左下至右上） 
	 * @param resultArray 
	 * @param value 
	 * @return 
	 */  
	private static boolean checkLeftBottom2RightTop(final String[][] resultArray, int row, int col, String value) {  
	    int arrayLen = resultArray.length;  
	    if ((row + col) == (arrayLen - 1)) {  
	        for (int i = 0; i < arrayLen; i++) {  
	            if (value.equals(resultArray[arrayLen - i - 1][i])) {  
	                return false;  
	            }  
	        }  
	    }  
	    return true;  
	}  
	
	/** 
	 * 执行所有校验 
	 * @param resultArray 
	 * @param row 
	 * @param col 
	 * @param value 
	 * @param checkCross 
	 * @return 
	 */  
	private static boolean checkAll(final String[][] resultArray, int row, int col, String value, boolean checkCross) {  
	    // 行校验  
	    if (!checkRow(resultArray, row, value)) {  
	        return false;  
	    }  
	  
	    // 列校验  
	    if (!checkColumn(resultArray, col, value)) {  
	        return false;  
	    }  
	  
	    // 宫校验  
	    if (!checkBlock(resultArray, row, col, value)) {  
	        return false;  
	    }  
	  
	    // 对角线校验  
	    if (checkCross) {  
	        // 对角线校验（左上至右下）  
	        if (!checkLeftTop2RightBottom(resultArray, row, col, value)) {  
	            return false;  
	        }  
	        // 对角线校验（左下至右上）  
	        if (!checkLeftBottom2RightTop(resultArray, row, col, value)) {  
	            return false;  
	        }  
	    }  
	  
	    return true;  
	}  
	/** 
	 * 校验是否已经填好 
	 * @param value 
	 * @return 
	 */  
	private static boolean isUnselect(String value) {  
	    return "".equals(value) || "0".equals(value);  
	}  
	
	/** 
	 * 复制数组 
	 * @param array 
	 * @return 
	 */  
	private static String[][] copyArray(final String[][] array) {  
	    int rowCount = array.length;  
	    int colCount = array[0].length;  
	    String[][] copy = new String[rowCount][colCount];  
	    for (int i = 0; i < rowCount; i++) {  
	        for (int j = 0; j < colCount; j++) {  
	            copy[i][j] = array[i][j];  
	        }  
	    }  
	    return copy;  
	}  
	
	/** 
	 * 输出结果 
	 * @param resultArray 
	 */  
	private static void printResult(final String[][] resultArray) {  
	    System.out.println("\n--------------------------------");  
	    int arrayLen = resultArray.length;  
	    for (int i = 0; i < arrayLen; i++) {  
	        System.out.println(Arrays.asList(resultArray[i]));  
	    }  
	}  
	
	/** 
	 * 数独解题 
	 * @param dataArray 待选列表 
	 * @param resultArray 前面（resultIndex-1）个的填空结果 
	 * @param resultIndex 选择索引，从0开始 
	 * @param checkCross 是否是对角线数独 
	 */  
	private static void sudoSelect(String[] dataArray, final String[][] resultArray, int resultIndex, boolean checkCross) {  
	    int resultLen = resultArray.length;  
	    if (resultIndex >= (int) Math.pow(resultLen, 2)) {  
	        // 全部填完时，输出排列结果  
	        printResult(resultArray);  
	        return;  
	    }  
	  
	    int row = (int) resultIndex / resultLen;  
	    int col = resultIndex % resultLen;  
	    if (isUnselect(resultArray[row][col])) {  
	        // 逐个尝试，递归选择下一个  
	        for (int i = 0; i < dataArray.length; i++) {  
	            if (checkAll(resultArray, row, col, dataArray[i], checkCross)) {  
	                // 排列结果不存在该项，才可选择  
	                String[][] resultCopy = copyArray(resultArray);  
	  
	                resultCopy[row][col] = dataArray[i];  
	                sudoSelect(dataArray, resultCopy, resultIndex + 1, checkCross);  
	            }  
	        }  
	    } else {  
	        // 递归选择下一个  
	        String[][] resultCopy = copyArray(resultArray);  
	        sudoSelect(dataArray, resultCopy, resultIndex + 1, checkCross);  
	    }  
	}  
	
	/** 
	 * 初始化结果数组 
	 * @param dataArray 待选列表 
	 * @return 
	 */  
	public static String[][] initResultArray(String[] dataArray) {  
	    int arrayLen = dataArray.length;  
	    String[][] resultArray = new String[arrayLen][arrayLen];  
	    for (int i = 0; i < arrayLen; i++) {  
	        for (int j = 0; j < arrayLen; j++) {  
	            resultArray[i][j] = "0";  
	        }  
	    }  
	    return resultArray;  
	} 
	
	/** 
	 * 初始化结果数组 
	 * @param resultString 结果字符串 
	 * @return 
	 */  
	public static String[][] initResultArray(String resultString) {  
	    int arrayLen = (int) Math.sqrt(resultString.length());  
	    String[][] resultArray = new String[arrayLen][arrayLen];  
	    for (int i = 0; i < arrayLen; i++) {  
	        for (int j = 0; j < arrayLen; j++) {  
	            resultArray[i][j] = "" + resultString.charAt(i * arrayLen + j);  
	        }  
	    }  
	    return resultArray;  
	}  
	
	/** 
	 * 9*9数独给定已选字符串求解 
	 * @param resultString 数独题目 
	 */  
	public static void sudoSelect(String resultString) {  
	    String[][] resultArray = initResultArray(resultString);  
	    sudoSelect(new String[] {  
	            "1", "2", "3", "4", "5", "6", "7", "8", "9"  
	    }, resultArray);  
	}  
	  
	/** 
	 * N*N数独给定结果数组求解 
	 * @param dataArray 待选列表 
	 * @param resultArray 已选结果数组 
	 */  
	public static void sudoSelect(String[] dataArray, final String[][] resultArray) {  
	    sudoSelect(dataArray, resultArray, false);  
	}  
	  
	/** 
	 * 排列选择（从列表中选择n个排列） 
	 * @param dataArray 待选列表 
	 * @param resultArray 已选结果 
	 * @param checkCross 是否校验对角线 
	 */  
	public static void sudoSelect(String[] dataArray, final String[][] resultArray, boolean checkCross) {  
	    sudoSelect(dataArray, resultArray, 0, checkCross);  
	}  
	
	public static void main(String[] args) {
		// 求解给定数独所有可能  
	    sudoSelect(new String[] {  
	            "1", "2", "3", "4", "5", "6", "7", "8", "9"  
	    }, new String[][] {  
	            {  
	                    "0", "0", "0", "0", "1", "0", "0", "5", "4"  
	            }, {  
	                    "8", "0", "0", "0", "0", "0", "0", "0", "0"  
	            }, {  
                    	"0", "0", "0", "0", "0", "0", "0", "0", "0"  
	            }, {  
	                    "6", "5", "0", "4", "0", "0", "0", "0", "0"  
	            }, {  
	                    "0", "0", "0", "0", "0", "2", "7", "3", "0"  
	            }, {  
	                    "0", "0", "0", "0", "0", "0", "0", "0", "0"  
	            }, {  
	                    "2", "1", "0", "0", "0", "0", "8", "0", "0"  
	            }, {  
	                    "7", "0", "0", "0", "0", "0", "3", "0", "0"  
	            }, {  
	                    "0", "0", "0", "3", "5", "0", "0", "0", "0"  
	            } 
	    });  
	  
	    // 求解给定数独所有可能  
	    // http://tieba.baidu.com/p/4813549830  
	    // #9806 002300609000000075100060000504100008060050040800007102000030001250000000907004200  
	    // #9807 010000000000294000008300709180002040050000080030800096401003800000471000000000020  
	    // #9808 100200905000080000400600023010005060000060000050400030840001007000070000507002001  
	    // #9809 300500090400000500002310000053080010000090000060050370000021800001000004080007006  
	    // #9810 010500000090073000804020000400000100780060029002000005000030207000480060000006090  
	    
	    //("002300609000000075100060000504100008060050040800007102000030001250000000907004200");  
	   // sudoSelect("010000000000294000008300709180002040050000080030800096401003800000471000000000020");  
	   // sudoSelect("100200905000080000400600023010005060000060000050400030840001007000070000507002001");  
	   // sudoSelect("300500090400000500002310000053080010000090000060050370000021800001000004080007006");  
	   // sudoSelect("010500000090073000804020000400000100780060029002000005000030207000480060000006090");  

	}

}

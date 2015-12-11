/*

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area https://leetcode.com/problems/rectangle-area/

Assume that the total area is never beyond the maximum possible value of int.

*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        
        int bottomLeftX = Math.max(A, E);
        int bottomLeftY = Math.max(B, F);
        int topRightX = Math.min(C, G); 
        int topRightY = Math.min(D, H);
        
        int overlap = 0; 
        if(bottomLeftX < topRightX && bottomLeftY < topRightY){   // 判断是否有重叠部分
            overlap = (topRightX - bottomLeftX) * (topRightY - bottomLeftY);
        }
        
        return sum - overlap;
    }
}

两个矩形的左右上下相对位置是不固定的，所以用min/max来确定重叠部分的坐标。
用重叠部分的坐标来判断重叠矩形是否存在，较简单，而不是用原始矩形坐标判断。
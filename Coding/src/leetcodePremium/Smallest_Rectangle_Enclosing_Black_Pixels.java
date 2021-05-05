/*completed
 * 
 *  An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
For example, given the following image: 
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2, 

Return 6. 
 *  
 *  */

package leetcodePremium;

public class Smallest_Rectangle_Enclosing_Black_Pixels {

	public int minArea(char[][] image, int x, int y) {
        if(image.length == 0) return 0;

        int left = y, right = y, top = x, bottom = x;
        //get topmost
        for(int i = 0 ; i < x; i++){
            if(findOneByRow(image, i, 0, image[0].length - 1)){
                top = i;
                break;
            }
        }
        //get leftmost
        for(int i = 0 ; i < y ; i++){
            if(findOneByCol(image, i, 0, image.length - 1)){
                left = i;
                break;
            }
        }
        //get rightmost
        for(int i = image[0].length - 1; i > y; i--){
            if(findOneByCol(image, i, 0, image.length - 1)){
                right = i;
                break;
            }
        }
        //get bottommost
        for(int i = image.length - 1; i > x; i--){
            if(findOneByRow(image, i, 0, image[0].length - 1)){
                bottom = i;
                break;
            }
        }

        return (right - left + 1) * (bottom - top + 1);
    }

    private boolean findOneByRow(char [][]image, int row, int i, int j){

        if(i <= j){
            int mid = (i + j) / 2;
            if(image[row][mid] == '1')
                return true;
            else{
                return findOneByRow(image, row, i, mid - 1) || 
                    findOneByRow(image, row, mid + 1, j);
            }
        }

        return false;
    }

    private boolean findOneByCol(char [][]image, int col, int i, int j){
        if(i <= j){
            int mid = (i + j) / 2;
            if(image[mid][col] == '1')
                return true;
            else{
                return findOneByCol(image, col, i, mid - 1) || 
                    findOneByCol(image, col, mid + 1, j);
            }
        }

        return false;
    }
	
}

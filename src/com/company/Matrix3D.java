package com.company;

import com.company.elements.invisible.Normal;
import com.company.elements.invisible.Point;
import com.company.elements.invisible.Vector;

public class Matrix3D {
    public double[][] matrixArr = null;

    public void multiplyMatrices( double[][] secondMatrix) {
        double[][] result = new double[this.matrixArr.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(this.matrixArr, secondMatrix, row, col);
            }
        }

        this.matrixArr = result;
    }

    public double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public Normal multiplyNormal( Normal n){
        double [] result = new double[this.matrixArr.length];
        double [] vectorToMult = new double[]{n.getX(),n.getY(),n.getZ(),1};
        for(int row = 0; row < result.length ; row++) {
            int el = 0;
            for (int col = 0; col < 4; col++) {
                el += this.matrixArr[row][col] * vectorToMult[col];
            }
        result[row] = el;
    }
        return new Normal(result[0],result[1],result[2]);
    }

    public Normal multiplyVector( Vector v){
        double [] result = new double[this.matrixArr.length];
        double [] vectorToMult = new double[]{v.getX(), v.getY(), v.getZ(),1};
        for(int row = 0; row < result.length ; row++) {
            int el = 0;
            for (int col = 0; col < 4; col++) {
                el += this.matrixArr[row][col] * vectorToMult[col];
            }
            result[row] = el;
        }
        return new Normal(result[0],result[1],result[2]);
    }

    public Point multiplyPoint(Point v){
        double [] result = new double[this.matrixArr.length];
        double [] vectorToMult = new double[]{v.getX(), v.getY(), v.getZ(),1};
        for(int row = 0; row < result.length ; row++) {
            int el = 0;
            for (int col = 0; col < 4; col++) {
                el += this.matrixArr[row][col] * vectorToMult[col];
            }
            result[row] = el;
        }
        return new Point(result[0],result[1],result[2]);
    }

    public void move (double x, double y, double z){
        double [][] moveMatrix = new double[][]{
                new double[]{1, 0, 0, x},
                new double[]{0, 1, 0, y},
                new double[]{0, 0, 1, z},
                new double[]{0, 0, 0, 1}
        };
    if(this.matrixArr == null){
        this.matrixArr = moveMatrix;
    }
    else {
        this.multiplyMatrices(moveMatrix);
    }
    }

    public void scale(double x, double y, double z) {
        double[][] new_move = new double[][]{
                new double[]{x, 0, 0, 0},
                new double[]{0, y, 0, 0},
                new double[]{0, 0, z, 0},
                new double[]{0, 0, 0, 1}
        };
        if (this.matrixArr == null) {
            this.matrixArr = new_move;
        } else {
            this.multiplyMatrices(new_move);
        }
    }


    public void rotateX(double xAngle) {
        double rad = Math.toRadians(xAngle);
        double[][] new_move = new double[][]{
                new double[]{Math.cos(rad), -Math.sin(rad), 0, 0},
                new double[]{Math.sin(rad), Math.cos(rad), 0, 0},
                new double[]{0, 0, 1, 0},
                new double[]{0, 0, 0, 1}
        };
        if (this.matrixArr == null) {
            this.matrixArr = new_move;
        } else {
            this.multiplyMatrices(new_move);
        }
    }


    public void rotateY(double yAngle) {
        double rad = Math.toRadians(yAngle);
        double[][] new_move = new double[][]{
                new double[]{Math.cos(rad), 0, Math.sin(rad), 0},
                new double[]{0, 1, 0, 0},
                new double[]{-Math.sin(rad), 0, Math.cos(rad), 0},
                new double[]{0, 0, 0, 1}
        };
        if (this.matrixArr == null) {
            this.matrixArr = new_move;
        } else {
            this.multiplyMatrices(new_move);
        }
    }

    public void rotateZ(double zAngle) {
        double rad = Math.toRadians(zAngle);
        double[][] new_move = new double[][]{
                new double[]{1, 0, 0, 0},
                new double[]{0, Math.cos(rad), -Math.sin(rad), 0},
                new double[]{0, Math.sin(rad), Math.cos(rad), 0},
                new double[]{0, 0, 0, 1}
        };
        if (this.matrixArr == null) {
            this.matrixArr = new_move;
        } else {
            this.multiplyMatrices(new_move);
        }
    }
    
    public double[][] getMatrixArr() {
        return matrixArr;
    }

    public void setMatrixArr(double[][] matrixArr) {
        this.matrixArr = matrixArr;
    }
}


class DataSet {
    private float[] x;
    private float[] y;

    public DataSet() {
        x = new float[]{23,26,30,34,43,48,52,57,58};
        y = new float[]{651,762,856,1063,1190,1298,1421,1440,1518};
    }
    public float[] getX() {
        return x;
    }
    public float[] getY() {
        return y;
    }
}

class DiscreteMaths {
    public DiscreteMaths() {}

    // sumatoria de x
    public float sumX(float[] x) {
        float totalX = 0;

        for (int i = 0; i < x.length; i++) {
            totalX += x[i];
        }
        return totalX;
    }

    // sumatoria de y 
    public float sumY(float[] y) {
        float totalY = 0;

        for (int i = 0; i < y.length; i++) {
            totalY += y[i];
        }
        return totalY;
    }

    // sumatorias de x por y
    public float sumXY(float[] x,float[] y) {
        float totalXY = 0;

        for (int i = 0; i < y.length; i++) {
            totalXY += x[i]*y[i];
        }
        return totalXY;
    }

    public float sumX2(float[] x) {
        float totalX2 = 0;

        for (int i = 0; i < x.length; i++) {
            totalX2 += (x[i]*x[i]);
        }
        return totalX2;
    }
}

class SimpleLinear {
    public static void main(String[] args) {
        DataSet dataset = new DataSet();
		DiscreteMaths discretemaths= new DiscreteMaths();

        float sumX = discretemaths.sumX(dataset.getX());
        float sumY = discretemaths.sumY(dataset.getY());
        float sumXY= discretemaths.sumXY(dataset.getX(),dataset.getY());
        float sumX2= discretemaths.sumX2(dataset.getX());
        float n    = dataset.getX().length;
        // Obtencion d beta 1
        float b1 = ((n*sumXY)-(sumX*sumY))/((n*sumX2)-(sumX*sumX));
        // Obtencion de beta 0
        float b0 = (sumY-(b1*sumX))/n;
        float SSres = 0;
        for (int i = 0; i < dataset.getX().length; i++) {
            System.out.println("Entrada X: "+dataset.getX()[i]+" Predeccion Y: "+(b0+(b1*dataset.getX()[i])));
            float predictedY = b0 + (b1 * dataset.getX()[i]);
            float residual = dataset.getY()[i] - predictedY;
            SSres += Math.pow(residual, 2);
        }

        float meanY = sumY / dataset.getY().length;
        float SStot = 0;
        for (int i = 0; i < dataset.getY().length; i++) {
            float deviation = dataset.getY()[i] - meanY;
            SStot += Math.pow(deviation, 2);
        }
        float Rsquared = 1 - (SSres / SStot);
        System.out.println("R-squared: " + Rsquared);



    }
}
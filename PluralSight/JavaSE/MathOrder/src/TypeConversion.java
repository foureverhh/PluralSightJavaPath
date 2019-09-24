public class TypeConversion {

    float floatVal = 1.0f;
    double doubleVal = 4.0d;
    byte byteVal = 7;
    short shortVal = 7;
    long longVal= 5;

    public TypeConversion(float floatVal, double doubleVal, byte byteVal, short shortVal, long longVal) {
        this.floatVal = floatVal;
        this.doubleVal = doubleVal;
        this.byteVal = byteVal;
        this.shortVal = shortVal;
        this.longVal = longVal;
    }

    public void conversionByteToShort(){
        shortVal = byteVal ;
        System.out.println("Success!");
    }

    public void conversionByteToLong(){
        longVal = byteVal;
        System.out.println("Byte To Long");
    }

    public void byteMinusLong(){
        System.out.println(byteVal);
        System.out.println(longVal);
        System.out.println(byteVal - longVal);
    }

    public void longToByte(){
        byteVal = (byte) longVal;
        System.out.println(byteVal);
    }

    public void longMinusFloat(){

        System.out.println(longVal - floatVal);

    }

    public void longMinusDouble(){
        System.out.println(longVal - doubleVal);
    }
}

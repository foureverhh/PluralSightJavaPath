public class Main {

    public static void main(String[] args) {
       int valA = 21;
       int valB = 6;
       int valC = 3;
       int valD =1;

       int result1 = valA - valB / valC;
       int result2 = (valA - valB) / valC;

       //System.out.println(result1);
       //System.out.println(result2);

       int result3 = valA / valC * valD + valB; // 13
        int result4 = valA / (valC *(valD + valB)); // 1

        //System.out.println(result3);
       // System.out.println(result4);

        //System.out.println("ConversionTest");

        TypeConversion conversionTest = new TypeConversion(1.0f,6.0d,(byte) 4,(short)7,5);
        //conversionTest.conversionByteToShort();
       // conversionTest.conversionByteToLong();
      //  conversionTest.byteMinusLong();
      //  conversionTest.longToByte();
       // conversionTest.longMinusFloat();
        //conversionTest.longMinusDouble();
    }
}

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Scanner;

public class ConvertNumberToWords {

  private static final String[] tens = {
    "",
    " ten",
    " twenty",
    " thirty",
    " forty",
    " fifty",
    " sixty",
    " seventy",
    " eighty",
    " ninety"
  };

  private static final String[] numBelowTwenty = {
    "",
    " one",
    " two",
    " three",
    " four",
    " five",
    " six",
    " seven",
    " eight",
    " nine",
    " ten",
    " eleven",
    " twelve",
    " thirteen",
    " fourteen",
    " fifteen",
    " sixteen",
    " seventeen",
    " eighteen",
    " nineteen"
  };

  private ConvertNumberToWords() {}

  private static String convertLessThanTwoThousand(int number) {
    String tillNowStr;

    if (number % 100 < 20){
      tillNowStr = numBelowTwenty[number % 100];
      number /= 100;
    }  else {
      tillNowStr = numBelowTwenty[number % 10];
      number /= 10;

      tillNowStr = tens[number % 10] + tillNowStr;
      number /= 10;
    }
    if (number == 0) return tillNowStr;
    return numBelowTwenty[number] + ( tillNowStr.isEmpty()? " hundred "+tillNowStr:" hundred and "+tillNowStr) ;
  }


  public static String convert(String snumber) {
	  
	  Optional<String> checkNull= Optional.ofNullable(snumber);
	  if( !checkNull.isPresent()){
		  return "Input is null";
	  }
	// 0 to 999 999 999 999
	long number = 0l;
	try {
		  number = Long.parseLong(snumber);
		  if (number == 0) { return "zero"; }
	} catch (Exception e) {
		return "Invalid input";
	}


    // pad with "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int billions = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int millions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int thousands = Integer.parseInt(snumber.substring(9,12));

    String tradBillions;
    switch (billions) {
    	case 0:
    		tradBillions = "";
    		break;
    	case 1 :
    		tradBillions = convertLessThanTwoThousand(billions)
    		+ " billion ";
    		break;
    	default :
    		tradBillions = convertLessThanTwoThousand(billions)
    		+ " billion ";
    	}
    String result =  tradBillions;

    String tradMillions;
    switch (millions) {
    	case 0:
    		tradMillions = "";
    		break;
    	case 1 :
    		tradMillions = convertLessThanTwoThousand(millions)
    		+ " million ";
    		break;
    	default :
    		tradMillions = convertLessThanTwoThousand(millions)
    		+ " million ";
    	}
    	result =  result + tradMillions;

    	String tradHundredThousands;
    	switch (hundredThousands) {
    	case 0:
    		tradHundredThousands = "";
    		break;
    	case 1 :
    		tradHundredThousands = "one thousand ";
    		break;
    	default :
    		tradHundredThousands = convertLessThanTwoThousand(hundredThousands)
    		+ " thousand ";
    	}
    	result =  result + tradHundredThousands;

    	String tradThousand;
    	tradThousand = convertLessThanTwoThousand(thousands);
    	result =  result + tradThousand;
    	// remove extra spaces!
    	return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
  }

  /**
   * testing
   * @param args
   */
  public static void main(String[] args) {
	// Using Scanner for Getting Input from User 
      Scanner in = new Scanner(System.in); 

      String input = in.nextLine(); 
	 // String number = "56945781";
    System.out.println(ConvertNumberToWords.convert(input));

  }
}

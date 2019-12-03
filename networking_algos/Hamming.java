import java.util.Scanner;

public class Hamming {

    private static boolean one_counter(int parity_bit, int data_bits[]){
        System.out.println("BITS ARE : "+ parity_bit + " " + data_bits[2] + " " + data_bits[1] + " " + data_bits[0] + "\n");
        return ((((parity_bit + data_bits[2] + data_bits[1] + data_bits[0]) % 2 ) == 0 ) ? false : true);
    }
    
    private static void correct(int[] data_array){
        
        System.out.println("\n\nENTERED BITS ARE");
        System.out.println("\nd7 d6 d5 P4 d3 P2 P1");
        
        for(int b: data_array) {
            System.out.print(b + "  ");
        }
        
        int parity_bit_1 = data_array[6]; // 6 is 0
        int parity_bit_2 = data_array[5]; // 5 is 1
        int parity_bit_4 = data_array[3]; // 3 is 3
        
        int data_bits_for_p4[] = new int[] { data_array[0], data_array[1],data_array[2]};
        int data_bits_for_p2[] = new int[] { data_array[0], data_array[1],data_array[4]};
        int data_bits_for_p1[] = new int[] { data_array[0], data_array[2],data_array[4]};
        
        // For p4
        System.out.println("\n\n========================");
        System.out.println(" CHECKING PARITY FOR P4");
        System.out.println("========================\n");
        boolean odd_even_temp_p4 = one_counter(parity_bit_4, data_bits_for_p4);
        if(odd_even_temp_p4) {
            System.out.println("For P4 the number of 1s are odd setting P4 = 1");
            parity_bit_4 = 1;
        } else {
            System.out.println("For P4 the number of 1s are even setting P4 =  0");
            parity_bit_4 = 0;        
        }
        
        // For p2
        System.out.println("\n\n========================");
        System.out.println(" CHECKING PARITY FOR P2");
        System.out.println("========================\n");
        boolean odd_even_temp_p2 = one_counter(parity_bit_2, data_bits_for_p2);
        if(odd_even_temp_p2) {
            System.out.println("For P2 the number of 1s are odd setting P2 = 1");
            parity_bit_2 = 1;
        } else {
            System.out.println("For P2 the number of 1s are even setting P2 = 0");
            parity_bit_2 = 0;        
        }
        
        
        // For p1
        System.out.println("\n\n========================");
        System.out.println(" CHECKING PARITY FOR P1");
        System.out.println("========================\n");
        boolean odd_even_temp_p1 = one_counter(parity_bit_1, data_bits_for_p1);
        if(odd_even_temp_p1) {
            System.out.println("For P1 the number of 1s are odd setting P1 =  1");        
            parity_bit_1 = 1;
        } else {
            System.out.println("For P1 the number of 1s are even setting P1 =  0");
            parity_bit_1 = 0;        
        }
        
        
        int incorrect_bit_index = ( parity_bit_4 * 4 ) + ( parity_bit_2 * 2 ) + parity_bit_1;
        System.out.println("\n\n==========================\n");
        System.out.println("INCOORECT BIT IS AT " + incorrect_bit_index);
        
        System.out.println("\nPREVIOUS BITS WERE\n");
        System.out.println("d7 d6 d5 P4 d3 P2 P1");
        
        for(int b: data_array) {
            System.out.print(b + "  ");
        }
        
        System.out.println("\n\nINVERTING THE BIT AT "+incorrect_bit_index);
        
        System.out.println("\nCORRECTED BITS ARE");
        System.out.println("\nd7 d6 d5 P4 d3 P2 P1");
        
        for(int i = 0; i < data_array.length ; i++){
            if( i == (data_array.length - incorrect_bit_index) ) {
                if(data_array[i] == 0){
                    System.out.print(1 + "  ");
                } else{
                    System.out.print(0 + "  ");
                }
            }
            else{
                System.out.print(data_array[i] + "  ");
            }
        }
        
        System.out.println("\n========= PROGRAM ENDED ==========\n");
    }

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("HAMMING CODE TESTER (NETWORKING)");
		System.out.println("BY github.com/sharadcodes");
		System.out.print("ENTER THE DATA WITH EVEN PARITY ( A 7 bit data like: 1011011 ) : ");
		String data = sc.next();
		if(data.length() !=7 ){
            System.out.println("DATA LENGTH IS NOT 7 TRY AGAIN");
            System.exit(0);
		}
		else {
            int data_array[] = new int[data.length()];
            for(int index = data.length()-1 ; index >= 0  ; index--){
                data_array[index] =  Integer.parseInt(data.charAt(index) + "");
            }
            
            for(int b: data_array){
                if(!(b == 0 || b == 1)){
                    System.out.println("DATA CONTAINS BITS WHICH ARE NOT 1 or 0. Try Again");
                    System.exit(0);
                }
                else {
                    correct(data_array);
                    break;
                }
            }
		}
	}
}

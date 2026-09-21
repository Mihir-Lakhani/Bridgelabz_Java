public class ProfitAndLoss {
    public static void main(String[] args){

        int cost_price = 129;

        int selling_prize = 191;

        double profit = selling_prize - cost_price;

        double profit_percentage = (profit/cost_price) * 100.0;

        System.out.println("The Cost Price is INR " + cost_price + " and Selling Price is INR "+ selling_prize +"\n" +
                "The Profit is INR " + profit + " and the Profit Percentage is " + profit_percentage + "\n");
    }
}

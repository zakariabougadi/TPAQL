public class Calculatrice {
    private int result;

    public int additionner(int a, int b) {
        result = a + b;
        return result;
    }

    // Add getter for testing state
    public int getResult() {
        return result;
    }
}
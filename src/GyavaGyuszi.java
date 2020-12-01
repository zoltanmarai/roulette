public class GyavaGyuszi implements Player {
        String name = "Gyuszi";
        int result;
        int min = 10;
        @Override
        public String getName() {
            return name;
        }
        @Override
        public int getResult() {
            return result;
        }

        @Override
        public int getMin() {
            return min;
        }

        @Override
        public void setMin(int min) {
            this.min= min;
        }

        @Override
        public void setResult(int result) {
            this.result = result;
        }

        @Override
        public String strategy() {
            String st = "piros";
            return st;
        }

        @Override
        public int betStrategy(boolean winBefore, int bet) {

            return bet = 10;
        }




}

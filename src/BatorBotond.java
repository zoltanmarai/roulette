public class BatorBotond implements Player {
        String name = "Boti";
        int result= 1000;
        int min = 100;
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
        public int  strategy() {
            int st = 0;
            return st;
        }

        @Override
        public int betStrategy(boolean winBefore, int bet) {
            return bet = 100;
        }

}

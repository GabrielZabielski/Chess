package Chess;

public class History {

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return type +"Move to: xTo=" + xTo +", yTo=" + yTo+",";
    }

    private int type, xFrom, yFrom, xTo, yTo;



    History(final Builder builder){

        this.type = builder.type;
        this.xFrom = builder.xFrom;
        this.yFrom = builder.yFrom;
        this.xTo = builder.xTo;
        this.yTo = builder.yTo;

    }

    public static class Builder{
        private int type, xFrom, yFrom, xTo, yTo;

        public Builder type(int type){
            this.type = type;
            return this;
        }

        public Builder xFrom(int xFrom){
            this.xFrom = xFrom;
            return this;
        }

        public Builder yFrom(int yFrom){
            this.yFrom = yFrom;
            return this;
        }

        public  Builder xTo(int xTo){
            this.xTo = xTo;
            return this;
        }

        public Builder yTo(int yTo){
            this.yTo = yTo;
            return this;
        }

        public History build(){
            return new History(this);
        }
    }
}

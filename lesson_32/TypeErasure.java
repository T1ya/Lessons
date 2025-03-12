public class TypeErasure <E>{
    private Integer value;  //converts to Object on compilation!
    //due this we can't create a T class object
    public TypeErasure(Integer value) {
        //Parameter converts to Object on compilation!
        this.value = value;
    }
    //And can't make overlodaed methods with different param types

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static void main(String[] args) {
        TypeErasure<Integer> = new TypeErasure<>(5);
    }


}

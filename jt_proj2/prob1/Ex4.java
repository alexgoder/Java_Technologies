
// abstract class Figure {
//     public abstract void area ();
//     }

// class Area{
//     private Figure f;

//     public void setFigure(Figure f){
//         this.f=f;
//     }

//     public void calculate_area(){
//         this.f.area();
//     }
// }
    
// class Circle extends Figure{
//     public void area() {
//         System.out.println("Circle area");
//     }
// }

// class Rectangle extends Figure{
//     @Override
//     public void area() {
//         System.out.println("Rectangle area");
//     }
// }
        
// class Ex4{
//     public static void main(String[]args){
//         Area a=new Area();
//         a.setFigure(new Circle());
//         a.calculate_area();
//     }
// }
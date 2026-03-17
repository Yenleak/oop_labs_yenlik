public  abstract class Shape3D {
    public abstract double volume();
    public abstract double surfaceArea();
}

//цилиндр
    class Cylinder extends Shape3D {
        private double radius;
        private double height;

        public Cylinder(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }
        @Override
        public double volume() {
            return Math.PI * Math.pow(radius, 2) * height;
        }
    
        @Override
        public double surfaceArea() {
            return 2 * Math.PI * radius * (radius + height);
        }
    }

//сфера
    class Sphere extends Shape3D {
        private double radius;
    
        public Sphere(double radius) {
            this.radius = radius;
        }
    
        @Override
        public double volume() {
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        }
    
        @Override
        public double surfaceArea() {
            return 4 * Math.PI * Math.pow(radius, 2);
        }
    }

//куб
    class Cube extends Shape3D {
        private double side;

        public Cube(double side) {
            this.side = side;
        }

        @Override
        public double volume() {
            return Math.pow(side, 3);
        }

        @Override
        public double surfaceArea() {
            return 6 * Math.pow(side, 2);
        }
    }

class mmain{
    public static void main(String[] args) {
        Shape3D[] shapes = {
            new Cylinder(3.0, 5.0),
            new Sphere(4.0),
            new Cube(2.0)
        };
        for (Shape3D shape : shapes){
            System.out.println("Фигура: " + shape.getClass().getSimpleName());
            System.out.printf("Объем: %.2f%n", shape.volume());
            System.out.printf("Площадь поверхности: %.2f%n", shape.surfaceArea());
            System.out.println("---------------------------");
        }
    }
}
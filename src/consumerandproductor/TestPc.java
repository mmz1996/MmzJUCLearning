package consumerandproductor;

import javax.xml.soap.Node;

/**
 * @Classname TestPc
 * @Description TODO
 * @Date 2020/12/8 17:22
 * @Created by mmz
 */
/*利用管程的方法，解决消费者和生产者
* 生产者，消费者，仓库，缓冲区
* */

public class TestPc {
    public static void main(String[] args) {
        Container container = new Container();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

class Productor extends Thread{
    Container container;

    public Productor(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Product(i));
            System.out.println("生产了"+i+"只鸡");

        }
    }
}

class Consumer extends Thread{
    Container container;

    public Consumer(Container container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop().id+"只鸡");
        }
    }
}

class Product{
    int id;
    public Product(int id){
        this.id = id;
    }
}

class Container{
    private Product[] products =new Product[10];
    private int size = 0;
    // 生产者生产
    public synchronized void push(Product product){
        if(size == products.length){
            // 通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[size] = product;
        size++;

        this.notify();

    }

    public synchronized Product pop(){
        if(size == 0){
            // 等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size--;
        Product product = products[size];


        this.notify();
        return product;
    }
}
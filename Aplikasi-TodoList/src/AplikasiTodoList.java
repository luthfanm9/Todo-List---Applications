/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Luthfan
 */
public class AplikasiTodoList {

    
    public static String[]model=new String[10]; 
        public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testViewShowTodoList();
    }
    
    
    /**
     * Menampilkan todo list
     */
    public static  void showTodoList(){
        System.out.println("TODO LIST");
        for (var i = 0; i<model.length;i++){
            String todo = model[i];
            var no = i+1;
            
            if(todo!=null){
                System.out.println(no+"."+todo);
            
            }    
        
        
        }
            
    }
    
    public static void testShowTodoList(){
        showTodoList();
    }
    /**
     * Menambahkan todo ke list
     */
    public static void addTodoList(String todo){
      // cek apakah model penuh
      var isFull = true;
      for (int i = 0;i < model.length; i++) {
          if (model[i] == null){
              //model masih ada yang kosong
              isFull = false;
              break;
          }
          
      }
      
      // jika penuh, kita resize ukuran array 2x lipat
      if (isFull) {
          var temp = model;
          model = new String[model.length * 2];
          
          for (int i = 0; i < temp.length; i++) {
             model[i] = temp[i];  
             }
              
          }
          
          // tambah ke posisi yang data array nya NULL
          for(var i = 0; i < model.length; i++) {
            if (model[i] == null) {
               model[i] = todo;
                break;
            }
        
        }
                
    }
     
    public static void  testAddTodoList() {
        for (int i =0; i < 25; i++) {
            addTodoList("Contoh Todo Ke." + i);
        }
        
        
        
        showTodoList();
    }    
        
    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
              if (i == (model.length -1)) {
                model[i] = null;
              } else {
                model[i] = model [i + 1];
              }
            }
                           
           return true;
        }
    
    }
    public static String input(String info){
        System.out.println(info+": ");
        String data = scanner.nextLine();
        return data;
        
    }
    
    /**
     * Menampilkan menu todo list
     */
    public static void viewShowTodoList(){
        while (true) {
            showTodoList();
            
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            
            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
                    } else if (input.equals("x")) {
                    break;
                    } else {
                    System.out.println("Pilihan tidak dimengerti");

            }
        }
        
    }
    public static void testViewShowTodoList()  {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }
        
    /**
     * Menampilkan view menambahkan todolist
     */
    public static void viewAddTodoList(){
        System.out.println("Menambah TodoList");
        
        var todo = input("Todo (x jika batal");
        
        if(todo.equals("x")){
          //batal   
        } else {
        
            addTodoList(todo);
        }
    }
    
    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        
        var number = input("Nomor yang Dihapus (x Jika Batal)");
        
        if (number.equals("x")) {
          //batal
        } else {
          boolean success = removeTodoList(Integer.valueOf(number));
          if (!success) {
            System.out.println("Gagal menghapus todolist : " + number);
        }
        
    }
}
}
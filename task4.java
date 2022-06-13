public class task4 {
    // 4.	Написать программу, показывающую последовательность действий для игры “Ханойская башня” 
    public static void main(String[] args) {
        int n = 3;
        hanoi(n,'A','B','C');
    }
    static void hanoi(int n,char start,char mid,char end) {
        if(n==1) {
            System.out.println("Disk "+n+" From "+start+" To "+end);
            return;
        }
        hanoi(n-1,start,end,mid);
        System.out.println("Disk "+n+" From "+start+" To "+end);
        hanoi(n-1,mid,start,end);   
    }
}

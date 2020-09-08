import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] arr=new char[3][4];
        arr[0][0]='A';
        arr[0][1]='B';
        arr[0][2]='C';
        arr[0][3]='E';
        arr[1][0]='S';
        arr[1][1]='F';
        arr[1][2]='C';
        arr[1][3]='S';
        arr[2][0]='A';
        arr[2][1]='D';
        arr[2][2]='E';
        arr[2][3]='E';
        while(sc.hasNext()){
            String word=sc.next();
            boolean find=false;
            for(int i=0;i<3;i++){
                for(int j=0;j<4;j++){
                    if(dfs(arr,word,0,i,j,new boolean[3][4])){
                        System.out.println("true");
                        find=true;
                        break;
                    }
                }
                if(find) break;
            }
            if(!find){
                System.out.println("false");
            }
        }
    }

    private static boolean dfs(char[][] arr,String word,int index,int i,int j,boolean[][] v){
        if(index==word.length()) return true;
        if(i<0||j<0||i>=3||j>=4||arr[i][j]!=word.charAt(index)||v[i][j]){
            return false;
        }

        index++;
        v[i][j]=true;
        if(dfs(arr,word,index,i+1,j,v)||dfs(arr,word,index,i-1,j,v)
        ||dfs(arr,word,index,i,j+1,v)||dfs(arr,word,index,i,j-1,v)){
            return true;
        }
        index--;
        v[i][j]=false;
        return false;
    }
}


/*
* public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String[] arr=sc.nextLine().split(" ");
            for(String str:arr){
                boolean print=false;
                if(str.length()<8||str.length()>120){
                    System.out.println("1");
                    continue;
                }else{
                    boolean[] flag=new boolean[4];
                    int count=0;
                    for(int i=0;i<str.length();i++){
                        char c=str.charAt(i);
                        if(c>='0'&&c<='9'&&!flag[0]){
                            flag[0]=true;
                            count++;
                        }else if (c>='a'&&c<='z'&&!flag[1]){
                            flag[1]=true;
                            count++;
                        }else if(c>='A'&&c<='Z'&&!flag[2]){
                            flag[2]=true;
                            count++;
                        }else if(!flag[3]){
                            flag[3]=true;
                            count++;
                        }

                        if(count==4){
                            System.out.println("0");
                            print=true;
                            break;
                        }
                    }
                    if(!print){
                        System.out.println("2");
                    }
                }
            }
        }
    }
* */
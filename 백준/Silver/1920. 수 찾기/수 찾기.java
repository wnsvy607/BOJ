        import java.io.*;
        import java.util.*;
        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();
                int num = Integer.parseInt(bf.readLine());

                int[] arr = new int[num];

                StringTokenizer st = new StringTokenizer(bf.readLine());

                for (int i = 0; i < num; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(arr);


                int num2 = Integer.parseInt(bf.readLine());
                st = new StringTokenizer(bf.readLine());

                for (int i = 0; i < num2; i++) {
                    int p = Integer.parseInt(st.nextToken());

                    if(Arrays.binarySearch(arr,p) < 0){
                        sb.append("0\n");
                    }
                    else
                    {
                        sb.append("1\n");
                    }


                }
                System.out.println(sb);
            }
        }

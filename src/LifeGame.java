import java.util.Arrays;
import java.util.Random;


    public class LifeGame {
        int n=10;
        int m=10;
        //stanrdowe wymiary
        private boolean plansza[][];//plansza glowna
        private boolean plansza_t[][];
        //plansza przechowuje poprzednie pokolenie
        LifeGame()
        {
            plansza = new boolean[n][m];
//konstruktor
        }

        LifeGame(int n, int m){
            this.n=n;
            this.m=m;
            plansza = new boolean[n][m];
            //konstruktor nr.2
        }


        public void init(){
        /*
    Random r = new Random();
    for(int i=0;i<(2*n);i++)
    plansza[r.nextInt(n)][r.nextInt(m)]=true;
    */

            //kod zakomentowany wyżej wypełnia losowo część macierzy

            plansza_t=new boolean[n][m];
            plansza[5][5] = true; plansza[5][7] = true; plansza[5][9] = true;
            plansza[6][5] = true; plansza[6][9] = true;
            plansza[7][5] = true; plansza[7][9] = true;
            plansza[8][5] = true; plansza[8][9] = true;
            plansza[9][5] = true; plansza[9][7] = true; plansza[9][9] = true;
            //a tutaj prosty wzor ktory pokazuje jak dziala ten proLifeGamem
            //figura startowa to prostokat
        }

        private void checkCell(int w, int k){

            if(plansza[w][k] == false)//jesli niezywa
            {

                boolean temp[] = new boolean[8];//tymczasowa tablica
                Arrays.fill(temp, false);//wypelniam ją false

                temp[0]=(((w-1)>=0 && (k-1)>=0) && plansza_t[w-1][k-1]==true)?true:false;
                temp[1]=(w-1)>=0 && plansza_t[w-1][k]==true?true:false;
                temp[2]=(w-1)>=0 && (k+1)<m && plansza_t[w-1][k+1]==true?true:false;
                temp[3]=(k+1)<m && plansza_t[w][k+1]==true?true:false;
                temp[4]=(k+1)<m && (w+1)<m && plansza_t[w+1][k+1]==true?true:false;
                temp[5]=(w+1)<m && plansza_t[w+1][k]==true?true:false;
                temp[6]=(k-1)>=0 && (w+1)<m &&  plansza_t[w+1][k-1]==true?true:false;
                temp[7]=(k-1)>=0 && plansza_t[w][k-1]==true?true:false;
// sprawdzam kazdy z 8 sasiadów.
//mozna to petla zrobic ale takie rozwiazanie pokazuje istote Gry w Życie

                int suma_zywych_sasiadow=0;
                for(int i=0;i<8;i++){

                    if(temp[i]==true)
                        suma_zywych_sasiadow=suma_zywych_sasiadow+1;
                    //licze ilość sąsiadów

                }
                if(suma_zywych_sasiadow==3){
                    plansza[w][k]=true;
                    //jesli jest 3 to ozywiam
                }
            }

            if(plansza[w][k]== true) //jesli zyje
            {
                boolean temp[] = new boolean[8];
                Arrays.fill(temp, false);

                temp[0]=(((w-1)>=0 && (k-1)>=0) && plansza_t[w-1][k-1]==true)?true:false;
                temp[1]=(w-1)>=0 && plansza_t[w-1][k]==true?true:false;
                temp[2]=(w-1)>=0 && (k+1)<m && plansza_t[w-1][k+1]==true?true:false;
                temp[3]=(k+1)<m && plansza_t[w][k+1]==true?true:false;
                temp[4]=(k+1)<m && (w+1)<m && plansza_t[w+1][k+1]==true?true:false;
                temp[5]=(w+1)<m && plansza_t[w+1][k]==true?true:false;
                temp[6]=(k-1)>=0 && (w+1)<m &&  plansza_t[w+1][k-1]==true?true:false;
                temp[7]=(k-1)>=0 && plansza_t[w][k-1]==true?true:false;
//licze sasiadów

                int suma_zywych_sasiadow=0;
                for(int i=0;i<8;i++){

                    if(temp[i]==true)
                        suma_zywych_sasiadow=suma_zywych_sasiadow+1;

                    //dodaje wartosci true
                }

                if(suma_zywych_sasiadow==3 || suma_zywych_sasiadow ==2)
                {
                    //jesli ma 3 lub 2 sasiadow to zyje dalej
                    plansza[w][k]=true;

                }
                else{//jesli nie to umiera
                    plansza[w][k]=false;
                }
            }


        }

        public void Draw(){

            for(int i=0;i<n;i++){

                for(int j=0;j<m;j++){


                    plansza_t[i][j]=plansza[i][j];

                    //kopiuje pokolenie aktualne do tymczasowej macierzy
                }


            }

            for(int i=0;i<n;i++){

                for(int j=0;j<m;j++){


                    //wyswietlam plansze
                    if(plansza[i][j]==true)
                        System.out.print("#");
                    else
                        System.out.print(".");

                }

                System.out.println();
            }
            for(int i=0;i<n;i++){

                for(int j=0;j<m;j++){

                    //obliczam kolejne pokolenie
                    this.checkCell(i, j);

                }
            }

        }
    }





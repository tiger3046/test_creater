import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

interface test_data{
  String midori_onepara_spel []= {"life","Choose","own" ,"class" ,"different","Schedule","flute","carry","bring","cafeteria","Mexico","Sleep"
    ,"Poster","listen to","radio","thing","after","work","child","lovely"} ;
  String midori_onepara_ja[] ={"一生","選ぶ","自分の","授業","違った、いろいろ","スケジュール","フルート","持っている","持ってくる","カフェテリア"
    ,"メキシコ","ねる","ポスター","、、、を聞く","ラジオ","こと","、、のあとに","働く","子ども","かわいい"};
  String midori_twopara_spel [] = {"next","throw","sprint","Team","e-mail","twin","wizard","power","solve","problem","together","help","may"
    ,"then","suggest","perfect","whose","mine","theirs","hers","ours","textbook"};
  String midori_twopara_ja [] = {"次の","投げる","短距離走","チーム","Eメール","ふたご","魔法使い","カ","解決する","問題","いっしょに"
  ,"手伝う","してもよい","その時","提案する","完全な","だれの","私のもの","彼らのもの","彼女のもの","私たちのもの","教科書"};
  String midori_threepara_spel [] = {"work book","dictionary","bottle","everyone"
    ,"join","event","had","experience","lot","last","hot spring ","view","Picnic","Ceaner","history","drop","wallet","bought","did"
    ,"Sightseeing","blog","pretty","scarf","Penguin","took","hang","win","match","Yesterday","ago","week","said"
    ,"Say","die","war","remember","Pray","peace","take a trip to","at","step","wait","thick","made","for the first time"};
  String midori_threepara_ja [] = {"ワークブック","辞書","びん","だれでも","参加する","出来事","haveの過去形","体験","たくさん","この前の"
    ,"温泉","景色","ピクニック","そうじ機","歴史","落とす","さいふ","buyの過去形","doの過去形","観光","ブログ","かわいい","スカーフ"
    ,"ペンギン","takeの過去形","ぶら下げる","勝っ","試合","きのう","、、の前に","週","sayの過去形","言う","死ぬ","戦争","思いだす","祈る","平和"
    ,"...へ旅行する","すべて","階段","待っ","太い","makeの過去形", "初めて"};
  String miu_onepara_spel[] = {"need","find","clearly","scientists","enough","experiment","suddenly","nervous","disappeared"
     ,"arrive","decided","appeared","discover","cover","invite","expensive","carry","company","born","bright","move"
    };
  String miu_onepara_ja[] = {"～を必要とする","～を探す","はっきりと","科学者","十分な","実験","突然","緊張する","見えなくなる"
    ,"到着する","決定する","現れる","発見する","覆う","招待する","高価な","持っている","運ぶ","会社"
    ,"うまれる","退屈な","動かす"};

  String quotations[]={"今日の成果は過去の努力の結果であり、未来はこれからの努力で決まる（稲盛和夫/実業家・京セラなどの創業者）","真剣だからこそ、ぶつかる壁がある（松岡修造/元プロテニスプレイヤー）"
  ,"小さいことを重ねることが、とんでもないところに行くただひとつの道（イチロー/元メジャーリーガー）","明日はなんとかなると思う馬鹿者。今日でさえ遅すぎるのだ。賢者はもう昨日済ましている（チャールズ・クーリー／社会学者）"
  ,"考え込んでる時間があったら何かやればいいんだよ。何もしないでいるなんてもったいないよ（所ジョージ）","ステップバイステップ。どんなことでも、何かを達成する場合にとるべき方法はただひとつ、一歩ずつ着実に立ち向かうことだ。\nこれ以外に方法はない（マイケル・ジョーダン）"
  ,"人にできて、きみだけにできないことなんてあるもんか（ドラえもん）","明日からがんばるんじゃない。 今日をがんばり始めた者にのみ明日がくるんだよ！（賭博破壊録カイジ）","１カ月頑張れるかどうかで人生が変わる（林修）"
  ,"できると思えばできる、できないと思えばできない。これは、ゆるぎない絶対的な法則である。（パブロ・ピカソ）","天才とは努力する凡才のことである（チャールズ・チャップリン）"
  ,"もっとも『むずかしい事』は！いいかい！もっとも『むずかしい事』は！『自分を乗り越える事』さ！ぼくは自分の『運』をこれから乗り越える！！（ジョジョの奇妙な冒険/岸辺露伴）"
  ,"ふるえるぞハート！燃えつきるほどヒ─ト！！おおおおおっ刻むぞ血液のビート！（ジョジョの奇妙な冒険/ジョナサン・ジョースター）","「ところで平凡な俺よ 下を向いている暇はあるのか」(ハイキュー/田中龍之介)"
  ,"「逃げる方が　絶対後からしんどいって事は　もう知ってる」(ハイキュー/縁下力)","「ー才能は開花させるもの　ーセンスは磨くもの！！！」(ハイキュー/及川徹)"
  ,"「結局堅実に地道にコツコツ努力している奴等には敵わない。そう、たった一発で強くなろうなんて考えてる連中はしょせん何年も何十年も日々地道に鍛錬をくり返す奴等に勝つことなんてできやしないんだ」(銀魂/マダオ)"
  ,"もし一番の願いが叶わなくて 沈んでいるとしても､大きな目標にトライした ことは､将来必ず何かの力になるはずだ｡(坪田信貴)","人生には色んな困難が必ずあるし､ それをなんとかするには逃げずに立ち向かうしかないんだよね(坪田信貴)"
  };
  void datause();
}
//ユーザーからのデータの選択結果を受け取ります。
class Test_description_select{
  String studentselect = "";
  String paragraphselect = "";
  String languageselect = "";
  Test_description_select(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("テストを作成したい生徒を入力してください。\n（翠ちゃんはm,みうちゃんはiです。）\n" +
    "この次にスペースを開けて、\n作成したい単語の段落(1,2,3,4)、\n"+
    "日本語か英語かを入力してください。\n(日本語はj、英語はeです。)\n"+
    "(例:m 1 j) > ");
    //スペース区切りで入力データを受け取ります。
    this.studentselect = scanner.next();
    this.paragraphselect = scanner.next();
    this.languageselect = scanner.next();
  }
  //this method return users choice description by three variable.
  public String[] data_return(){
    String test_description[]= new String[3];
    test_description[0]=this.studentselect;
    test_description[1]=this.paragraphselect;
    test_description[2]=this.languageselect;
    return test_description;
  }

}

//this class create file.
class File_maker{
  public static void filecreate(String test[],String random_idennum[],String dictum[],int quotationslength){
    //ファイル名の生成
    String studentname = "";
    String paragraphnum = random_idennum[1];
    String language = "";
    if(random_idennum[0].equals("m")){
      studentname = "みどりちゃん";
    }else if(random_idennum[0].equals("i")){
      studentname = "みうちゃん";
    }else{
      System.out.println(random_idennum[0]);
      System.out.println("エラー");
    }

    if(random_idennum[2].equals("j")){
      language = "日本語";
    }else{
      language = "英語";
    }
    //ファイルの位置及び名前の最終決定
    String iden_num = String.format("/Users/hayashitaiga/Desktop/%s単語テスト%s行目%s.text",studentname,paragraphnum,language);
    Path p = Paths.get(iden_num);
    System.out.println(iden_num);

    try{
      Files.createFile(p);
    }catch(IOException e){
      System.out.println(e);
    }
    //テスト作成
    try{
       File file = new File(iden_num);

       if (checkBeforeWritefile(file)){
         FileWriter filewriter = new FileWriter(file);
         filewriter.write("単語テスト\n");
         filewriter.write("\n");
         filewriter.write("次の設問の英語を日本語に、日本語を英語にしなさい。\n");
         filewriter.write("\n");
       for(int i=0; i<10; i++){
          filewriter.write("第"+(i+1)+ "問："+test[i]+"　__________________________\n");
          filewriter.write("\n");
      }
         filewriter.write("　　/10\n");
         filewriter.write("\n");
         filewriter.write("\n");
         int quotations_number = (int)Math.ceil(Math.random() * (quotationslength));
         filewriter.write(dictum[quotations_number]);
         filewriter.close();
       }else{
         System.out.println("ファイルに書き込めません");
       }
     }catch(IOException e){
       System.out.println(e);
     }
  }

  private static boolean checkBeforeWritefile(File file){
    if (file.exists()){
      if (file.isFile() && file.canWrite()){
        return true;
      }
    }
    return false;
  }
}
//テストデータ決定
class Random_test implements test_data{
  List<String> specifiedrange = new ArrayList<String>();
  String user_select = "";
  String paragraph_select = "";
  String language_select="";

  Random_test(String[] choice){
      this.user_select=choice[0];
      this.paragraph_select = choice[1];
      this.language_select = choice[2];
  }

//テストに出題する問題を入力結果に基づき選定
  public void datause(){
    int test_range = 0;
    //利用する配列を入力値に基づき選定
    if(this.user_select.equals("m")){
      if(this.paragraph_select.equals("1")){
        if(this.language_select.equals("j")){
          test_range = midori_onepara_ja.length;
          specifiedrange=Arrays.asList(midori_onepara_ja);
        }else{
          test_range = midori_onepara_spel.length;
          specifiedrange=Arrays.asList(midori_onepara_spel);
        }
      }else if(this.paragraph_select.equals("2")){
        if(this.language_select.equals("j")){
          test_range = midori_twopara_ja.length;
          specifiedrange=Arrays.asList(midori_twopara_ja);
        }else{
          test_range = midori_twopara_spel.length;
          specifiedrange=Arrays.asList(midori_twopara_spel);
        }
      }else{
        if(this.language_select.equals("j")){
          test_range = midori_threepara_ja.length;
          specifiedrange=Arrays.asList(midori_threepara_ja);
        }else{
          test_range = midori_threepara_spel.length;
          specifiedrange=Arrays.asList(midori_threepara_spel);
      }
      }
    }else if(this.user_select.equals("i")){
      if(this.language_select.equals("j")){
        test_range = miu_onepara_ja.length;
        specifiedrange=Arrays.asList(miu_onepara_ja);
      }else{
        test_range = miu_onepara_spel.length;
        specifiedrange=Arrays.asList(miu_onepara_spel);
      }
    }else{
        System.out.println(this.user_select);
        System.out.println("適切な値を入力してください。");
    }
    //ランダム数を算出
    int random_num = (int)Math.ceil(Math.random() * (test_range/2));

    //テストデータを入力する用のカウンタ変数
    int i = 0;
    //出力するテストを格納するための配列
    String[] test = new String[test_range];
    Iterator<String> specifiedrange_iterated = specifiedrange.iterator();
    while (specifiedrange_iterated.hasNext()) {
            test[i] = specifiedrange_iterated.next();
            i++;
            System.out.println(i);
            if(i==test_range){
            //ランダムにテストを格納  
              for(int j=0; j<10; j++){
                test[j]=test[random_num];
                random_num++;
                System.out.println(test[j]);
              }
            break;
            }
    }
    String[] file_identify_num_array= new String[3];
    file_identify_num_array[0] = this.user_select;
    file_identify_num_array[1] = this.paragraph_select;
    file_identify_num_array[2] = this.language_select;
    //It has user choice.
    System.out.println(Arrays.toString(file_identify_num_array));
    String[] aphorismList = new String[quotations.length];
    aphorismList = quotations;
    int aphorismlength = aphorismList.length;
    File_maker fm = new File_maker();
    fm.filecreate(test ,file_identify_num_array,aphorismList,aphorismlength);
    System.out.println(specifiedrange.toString());
  }
}
//Under class is main class. 
public class test_creater{
    static String[] user_choice(){
    String user_choice[] = new String[3];
    Test_description_select tds = new Test_description_select();
    user_choice= tds.data_return();
    return user_choice;
  }
   public static void main(String[] args){
    Random_test rt = new Random_test(user_choice());
    rt.datause();
  }
}

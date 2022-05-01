public class Articels {
    private String title;
    private  String content;
    private String author;

    public Articels(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }



        //methods
        public void edit(String newContent){
            this.content = newContent;
        }

        public void changeAuthor(String newAuthor ){
            this.author = newAuthor;
        }

        public void renameTitle(String newTitle){
            this.title = newTitle;
        }

        @Override
        public  String toString(){
            return title + " - " + content + ":" +author;
        }


    }


import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler{
    String request = "";

    public String handleRequest(URI url){
        if(url.getPath().equals("/add-message")){
            if(url.getQuery().startsWith("s=")){
            String message = url.getQuery().substring(2,url.getQuery().length());
            request += "\n" + message;
            }
        }
    System.out.println(request);
    return request;
    }
}

class StringServer{
    public static void main(String[] args) throws IOException{
        if(args.length == 0){
            System.out.println("Missing port number! Try any port number between 1024 to 49151");
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}
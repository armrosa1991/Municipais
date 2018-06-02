import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MongoFilterReceitasMunicipais {

    public static MongoClient mongoClient;
    public static MongoDatabase mongoDbase;
    public static MongoCollection<Document> collection;
    public static MongoCursor<Document> mongoCursor;
    public static List<Municipe> listaMunicipios = new ArrayList<>();



    //Collection to Insert
    public static MongoCollection<Document> collectionFiltered;


    public static void main(String[] args) throws ParseException {

        mongoClient = new MongoClient("localhost", 27017);
        mongoDbase = mongoClient.getDatabase("local");
        collection = mongoDbase.getCollection("ReceitasMunicipais2014");
        collectionFiltered = mongoDbase.getCollection("ReceitasMunicipais2014_Filter");
        mongoCursor = collection.find().iterator();


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon"));

        try {
            while (mongoCursor.hasNext()) {
                Document doc = mongoCursor.next();

                ArrayList<Document> listOfMunicipes = (ArrayList<Document>) doc.get("d");

                for (Document d : listOfMunicipes) {
                    Municipe municipe = new Municipe();

                    municipe.setAutarquia(d.get("dscautarquia").toString());
                    municipe.setTimeStamp((dateFormat.parse(getTrimmedStringDate(d.get("Timestamp").toString()))));
                    municipe.setCodigoPeriodo(d.get("codigoperiodo").toString());
                    municipe.setDerramaIRC(Double.parseDouble(d.get("derramairc").toString()));
                    municipe.setFinanciamentoUE(Double.parseDouble(d.get("financiamentouniaoeuropeia").toString()));
                    municipe.setImi(Double.parseDouble(d.get("imi").toString()));
                    municipe.setImpostosMunicipais(Double.parseDouble(d.get("impostosmunicipais").toString()));
                    municipe.setImt(Double.parseDouble(d.get("imt").toString()));
                    municipe.setIuc(Double.parseDouble(d.get("iuc").toString()));
                    municipe.setOutrasReceitas(Double.parseDouble(d.get("outrasreceitas").toString()));
                    municipe.setReceitasTotais(Double.parseDouble(d.get("receitastotais").toString()));
                    municipe.setTaxasMultasOutrosImpostos(Double.parseDouble(d.get("taxasmultasoutrosimpostos").toString()));
                    municipe.setTransferenciasOrcamentoEstado(Double.parseDouble(d.get("transferenciasorcamentoestado").toString()));
                    municipe.setVendaBensServiços(Double.parseDouble(d.get("vendabensservicos").toString()));

                    listaMunicipios.add(municipe);

                }

                insertCorrectlyOnMongoDb(listaMunicipios);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            mongoCursor.close();
        }
    }

    public static String getTrimmedStringDate (String timeStamp){
        int index = timeStamp.indexOf('.');

        return  timeStamp.substring(0,index);
    }

    public static void insertCorrectlyOnMongoDb(List<Municipe> listaMunicipios){
        Collections.sort(listaMunicipios);
        ArrayList<Document> arrayOfDocuments = new ArrayList<>();
        int counter = 0;


        for(Municipe m : listaMunicipios){
            Document document = new Document();
            counter++;

            document.put("Autarquia",m.getAutarquia());
            document.put("Timestamp",m.getTimeStamp());
            document.put("CodigoPeriodo",m.getCodigoPeriodo());
            document.put("DerramaIRC",m.getDerramaIRC());
            document.put("FinanciamentoUE",m.getFinanciamentoUE());
            document.put("IMI",m.getImi());
            document.put("ImpostosMunicipais",m.getImpostosMunicipais());
            document.put("IMT",m.getImt());
            document.put("IUC",m.getIuc());
            document.put("OutrasReceitas",m.getOutrasReceitas());
            document.put("ReceitasTotais",m.getReceitasTotais());
            document.put("TaxasMultasOutrosImpostos",m.getTaxasMultasOutrosImpostos());
            document.put("TransferenciasOrcamentoEstado",m.getTransferenciasOrcamentoEstado());
            document.put("VendaBensServicos",m.getVendaBensServiços());


            arrayOfDocuments.add(document);
            if(counter == 5){
                Document d = new Document();
                d.append(m.getAutarquia(),arrayOfDocuments);
                collectionFiltered.insertOne(d);
                counter = 0;
                arrayOfDocuments.clear();
            }


        }


    }
}


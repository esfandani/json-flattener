import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

public class JsonFlattener {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String json = "{\"server\":{\"requestStartTime\":1512768975958,\"processId\":\"9260@dal-appblx095-08.prod.walmart.com\",\"processStartTime\":456745,\"threadId\":0,\"threadRequestNumber\":791275074,\"localAddress\":\"10.65.192.47\",\"localName\":\"127.0.0.1\",\"localPort\":443,\"requestEndTime\":1512768976260,\"applicationMicroseconds\":301859},\"request\":{\"remoteAddress\":\"10.65.134.137\",\"remotePort\":63987,\"method\":\"GET\",\"requestUrl\":\"/ip/Pandemic-Game/24017055\",\"queryString\":\"action=product_interest&action_type=title&beacon_version=1.0.2&bucket_id=irsbucketdefault&client_guid=0bcbdd25-99d5-4575-368a-08febb84a9d7&config_id=2&customer_id_enc&findingMethod=p13n&guid=0bcbdd25-99d5-4575-368a-08febb84a9d7&item_id=24017055&parent_anchor_item_id=11033837&parent_item_id=11033837&placement_id=irs-2-m2&reporter=recommendations&source=new_site&strategy=PWVUB&visitor_id=Uz8jVyOiRcgjkw7o_h-oMM\",\"protocol\":\"HTTP/1.1\",\"requestHeaderList\":[{\"name\":\"X-Forwarded-For\",\"valueList\":[\"174.193.130.166\"]},{\"name\":\"Referer\",\"valueList\":[\"https://www.walmart.com/ip/Days-of-Wonder-Ticket-To-Ride-Board-Game/11033837\"]},{\"name\":\"Dnt\",\"valueList\":[\"1\"]},{\"name\":\"Accept-Language\",\"valueList\":[\"en-us\"]},{\"name\":\"X-Akamai-Config-Log-Detail\",\"valueList\":[\"true\"]},{\"name\":\"Te\",\"valueList\":[\"chunked;q=1.0\"]},{\"name\":\"Accept-Encoding\",\"valueList\":[\"gzip\"]},{\"name\":\"Accept-Esi\",\"valueList\":[\"1.0\"]},{\"name\":\"Cache-Control\",\"valueList\":[\"no-cache\"]},{\"name\":\"X-Ak-Protocol\",\"valueList\":[\"h2\"]},{\"name\":\"X-F5-Forwarder\",\"valueList\":[\"l-dal-tier1c\"]},{\"name\":\"Accept\",\"valueList\":[\"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\"]},{\"name\":\"Connection\",\"valueList\":[\"TE\",\"keep-alive\"]},{\"name\":\"Akamai-Origin-Hop\",\"valueList\":[\"1\"]},{\"name\":\"DEVICE_TZ\",\"valueList\":[\"EST\"]},{\"name\":\"User-Agent\",\"valueList\":[\"Mozilla/5.0 (iPad; CPU OS 10_3_2 like Mac OS X) AppleWebKit/603.2.4 (KHTML, like Gecko) Version/10.0 Mobile/14F89 Safari/602.1\"]},{\"name\":\"Via\",\"valueList\":[\"1.1 akamai.net(ghost) (AkamaiGHost)\"]},{\"name\":\"wm_client_ip\",\"valueList\":[\"174.193.130.166\"]},{\"name\":\"Pragma\",\"valueList\":[\"no-cache\"]},{\"name\":\"Cookie\",\"valueList\":[\"AID=wmlspartner%3D0%3Areflectorid%3D0000000000000000000000%3Alastupd%3D1512745795741; TS011baee6=0103fe054715e4aba16f66798200fe28e4752227e8ffeaf6342bab30af575e916c176d5114bf71b858a9a9577c00d3817ff894759d; akavpau_p5=1512769536~id=089ccab62eacd6aa15498ae30196dd71; akavpau_p0=1512769535~id=0e2b82752fe67c72f85f49c943465fc4; akavpau_p3=1512769533~id=53a9c8d802d8b1c079b7c7bcf43dee4d; TBV=a0zye; s_pers=%20s_cmpstack%3D%255B%255B%2527seo_un%2527%252C%25271512745580884%2527%255D%255D%7C1670511980884%3B%20s_v%3DY%7C1512770739551%3B%20gpv_p11%3D%255BToys%255D%2520Product%2520Page%7C1512770739554%3B%20gpv_p44%3DProduct%7C1512770739557%3B%20s_vs%3D1%7C1512770739558%3B%20s_fid%3D5203B323C7C75E57-13ED9E0EDC1C9FC6%7C1575840981001%3B; bstc=YQZ81AW65ZmXqrx9x8C71Q; vtc=Uz8jVyOiRcgjkw7o_h-oMM; s_vi=[CS]v1|2D1555340507D17C-6000010A00000DB1[CE]; s_sess=%20ent%3DionCardGameProduct4994694%3B%20s_cc%3Dtrue%3B%20chan%3Dorg%3B%20c21_i%3DS2H%252CPUT%252CS2S%252CMP%252C%3B%20c21_v%3DPUT%252CMP%252CS2H%252CS2S%252C%3B%20c32_v%3DPUT%252CS2H%252CS2S%252C%3B%20v59%3DToys%3B%20v54%3D%255BToys%255D%2520Product%2520Page%3B%20cps%3D0%3B%20s_sq%3D%3B; TS01e3f36f=0103fe0547db887c1c9b2c3ba15cc3eee762151a03ffeaf6342bab30af575e916c176d5114b381a08b774d3839ad18581bbd5394dbdf49748c3588e0b3a05f5a4bb58f88ae7bde0ba68bab00b10efd2e3b57d49dec; TS018dc926=0130aff2328b2589b3e6d5f7fe76b25029d48734ba5544969b7c64e89838b168dfe7013c6f74794f0f6ff758b99cddb8c5a7de607df80b8c962fb97b91c795a0481590106d6698e277dd74fa5a2dc7025123efca80a48b2325f35f77341f2f135b23a55c3171065a5f35558387ff68efcd2ba741af; exp=3%2B1512768920%2BUz8jVyOiRcgjkw7o_h-oMM~%2B0%2B; account-flyout=1; athrvi=RVI~ha85ced-h4c3686-h2f4ed3f-h1d3c5f4-h33c10a9; com.wm.reflector=\\\"reflectorid:0000000000000000000000@lastupd:1512768933654@firstcreate:1512745572730\\\"; sps=i%2411033837%3B4994694%3B; DL=29211%2C34.000701904296875%2C-81.03479766845703%2Cip%2C29211%2CUSA%2CSC; NSID=5378.3-1183.4-4379.5-2214.5-5318.6-1286.6-1164.8-5291.9-4506.10-881.11-1339.11-4521.13-4440.14-634.28-4420.29-616.34-3724.37-511.37-624.37-5383.38; SSLB=2; __gads=ID=71e65768f29d6cce:T=1512745575:S=ALNI_MZuMn7iCY-V8AIRhkdR7n0A9gnO7g;walmart-item-id=24017055\"]},{\"name\":\"X-Akamai-State\",\"valueList\":[\"NC\"]},{\"name\":\"X-Akamai-Device-Characteristics\",\"valueList\":[\"is_tablet=true;device_os=iPhone OS;is_wireless_device=false\"]},{\"name\":\"Host\",\"valueList\":[\"www.walmart.com\"]}],\"requestSize\":0,\"scheme\":\"https\"},\"response\":{\"status\":200,\"responseHeaderList\":[{\"name\":\"Content-Type\",\"valueList\":[\"text/html; charset=utf-8\"]},{\"name\":\"WM_QOS.CORRELATION_ID\",\"valueList\":[\"63746390-c85-160380ec89afa7,63746390-c85-160380ec89a43a,63746390-c85-160380ec89a43a\"]},{\"name\":\"Set-Cookie\",\"valueList\":[\"AID=x; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; SameSite=Strict; Path=/\",\"com.wm.reflector=\\\"reflectorid:0000000000000000000000@lastupd:1512768981147@firstcreate:1512745572730\\\"; Max-Age=315360000; Expires=Mon, 06 Dec 2027 21:36:21 GMT; SameSite=Strict; Domain=.walmart.com; Path=/\",\"vtc=Uz8jVyOiRcgjkw7o_h-oMM;Path=/;Domain=.walmart.com;Expires=Thu, 09 Dec 2027 09:36:16 GMT;Max-Age=315576000\",\"bstc=YQZ81AW65ZmXqrx9x8C71Q;Path=/;Domain=.walmart.com;Expires=Fri, 08 Dec 2017 22:06:16 GMT;Max-Age=1800\",\"exp=3%2B1512768920%2BUz8jVyOiRcgjkw7o_h-oMM~%2B0%2B; Path=/; Domain=walmart.com; Expires=Fri, 08 Dec 2017 22:06:16 GMT; Max-Age=1800\"]},{\"name\":\"Cache-Control\",\"valueList\":[\"no-cache\"]},{\"name\":\"Strict-Transport-Security\",\"valueList\":[\"max-age=86400\"]},{\"name\":\"Date\",\"valueList\":[\"Fri, 08 Dec 2017 21:36:21 GMT\"]},{\"name\":\"Last-Modified\",\"valueList\":[\"Fri, 08 Dec 2017 21:36:16 GMT\"]},{\"name\":\"Connection\",\"valueList\":[\"keep-alive\"]},{\"name\":\"Vary\",\"valueList\":[\"accept-encoding\"]},{\"name\":\"X-Tb\",\"valueList\":[\"1\"]},{\"name\":\"Content-Encoding\",\"valueList\":[\"gzip\"]},{\"name\":\"Accept-Ranges\",\"valueList\":[\"bytes\"]}],\"responseSize\":82396},\"reqContextVarsList\":[{\"name\":\"ZincID\",\"value\":\"1:0:23:3047df:Dnt,X-Akamai-Config-Log-Detail,Akamai-Origin-Hop,Accept-Esi,wm_client_ip,X-Ak-Protocol,X-Akamai-State,DEVICE_TZ,X-Akamai-Device-Characteristics,X-F5-Forwarder:AG?HC?EFB?S?T?@MFI?????\"}],\"fetchTrace\":{\"wasSuccessful\":true,\"totalLatencyMs\":269,\"fetchAttemptLogList\":[{\"wasSuccessful\":true,\"latencyMs\":269}],\"unknown_lengthdelimited_4\":[\"ZWxlY3Ryb2RlLW5vZGVqcy5wcm9kLWEucHJvZHVjdHMuZ2xvYmFscHJvZHVjdHMuZ2xiLnByb2Qud2FsbWFydC5jb20\"],\"unknown_lengthdelimited_5\":[\"d3d3LndhbG1hcnQuY29t\"]},\"cacheHit\":false,\"unknown_lengthdelimited_10\":[\"ChdjbGVhbnVwIGNvb2tpZSBmb3IgZXhwbxDjBg\"],\"metadata\":{\"torbit_host\":\"dal-appblx095-08.prod.walmart.com\",\"total_events\":128,\"UID\":\"dal-appblx095-08.prod.walmart.com$1509987128786001821$101\",\"batch_number\":1509987128786001821,\"event_number\":101,\"batch_timestamp\":1512768976375}}";

        for(int i=0;i<100000;i++) {
            Map<String, String> map = flatten(json);
            System.out.println(map);
        }
        System.out.println(System.currentTimeMillis()-start);
//
//        long start = System.currentTimeMillis();
//        for(int i=0;i<100000;i++){
//            Map<String,Object> jsonMap =  com.github.wnameless.json.flattener.JsonFlattener.flattenAsMap(json);
//        }
//        System.out.println(System.currentTimeMillis()-start);
    }

    public static Map<String,String> flatten(String json){
        if(json == null || json.trim().equals("")){
            return Collections.emptyMap();
        }

;
       /* Map<String,String> map = new HashMap<String,String>();
        JsonElement root = gson.fromJson(json,JsonElement.class);
        map.put("root",json);
        flattenUtilsRecursive(map,root,"");*/
        //return map;
        return flattenUtils(json);

    }
    private static Map<String,String> flattenUtils(String json){
        Map<String,String> map = new HashMap<String,String>();
        JsonElement root = gson.fromJson(json,JsonElement.class);
        Deque<JsonElement> stack = new ArrayDeque<JsonElement>();
        Deque<String> pathStack = new ArrayDeque<String>();
        map.put("root",json);
        stack.add(root);
        pathStack.add("");

        while(!stack.isEmpty()){
            JsonElement element = stack.pop();
            String path = pathStack.pop();
            if(element.isJsonNull()){
                map.put(path,null);
                continue;
            }
            if(element.isJsonPrimitive()){
                map.put(path,element.getAsString());
                continue;
            }
            if(element.isJsonObject()){
                JsonObject jo = element.getAsJsonObject();
                for(Map.Entry<String, JsonElement> entry: jo.entrySet()){
                    String p = getPath(path,entry.getKey());
                    JsonElement child = entry.getValue();
                    stack.push(child);
                    pathStack.push(p);
                }
                continue;
            }
            if(element.isJsonArray()){
                JsonArray ja = element.getAsJsonArray();
                Iterator<JsonElement> iter = ja.iterator();
                int counter = 0;
                while(iter.hasNext()){
                    JsonElement child = iter.next();
                    String p =path+"["+counter+"]";
                    stack.push(child);
                    pathStack.push(p);
                    counter++;
                }
            }
        }
        return map;

    }
    private static void flattenUtilsRecursive(Map<String,String> accumulator, JsonElement element,String currentPath){
        if(element == null){
            return;
        }
        if(element.isJsonNull()){
            accumulator.put(currentPath,null);
            return;
        }
        if(element.isJsonPrimitive()){
           accumulator.put(currentPath,element.getAsString());
           return;
        }
        if(element.isJsonObject()){
            JsonObject jo = element.getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry: jo.entrySet()){
                String path = getPath(currentPath,entry.getKey());
                JsonElement child = entry.getValue();
                flattenUtilsRecursive(accumulator,child,path);
            }
            return;
        }
        if(element.isJsonArray()){
            JsonArray ja = element.getAsJsonArray();
            Iterator<JsonElement> iter = ja.iterator();
            int counter = 0;
            while(iter.hasNext()){
                JsonElement je = iter.next();
                flattenUtilsRecursive(accumulator,je,currentPath+"["+counter+"]");
                counter++;
            }
        }
    }
    private static String getPath(String root, String name){
        if(root.equals("")){
            return name;
        }
        return root+"."+name;
    }
}

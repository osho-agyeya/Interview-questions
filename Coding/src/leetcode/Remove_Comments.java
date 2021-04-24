//completed






package leetcode;

public class Remove_Comments {
	
    private boolean incomment;
    private String unfinish;
    private List<String> res;

    private void addLine(String line) {
        unfinish = "";
        if (!line.isEmpty())
            res.add(line);
    }
    
    private void processIncomment(String line) {
        int ind = line.indexOf("*/");
        if (ind == -1)
            return;
        incomment = false;
        processNotIncomment(line.substring(ind + 2));
    }

    private void processNotIncomment(String line) {
        int ind = line.indexOf("/*");
        int ind1 = line.indexOf("//");
        if (ind == -1 && ind1 == -1) {
            addLine(unfinish + line);
            return;
        }
        if (ind1 != -1 && (ind == -1 || ind1 < ind)) {
            addLine(unfinish + line.substring(0, ind1));
            return;
        } 
        incomment = true;
        unfinish += line.substring(0, ind);
        processIncomment(line.substring(ind + 2));
    }
    
    public List<String> removeComments(String[] source) {
        incomment = false;
        unfinish = "";
        res = new ArrayList<>();
        for (String line: source)
            if (incomment)
                processIncomment(line);
            else
                processNotIncomment(line);
        return res;
    }

}

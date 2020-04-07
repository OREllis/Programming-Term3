package com.uni.term3.programming.week1.exercises;

import com.uni.term3.programming.week1.examples.Graph;
import com.uni.term3.programming.week1.examples.Node;

public class Exercise1x10 {

    private static Graph graph = new Graph(false);

    private static final Node cloudServ = new Node(0, "Cloud Server");
    private static final Node inetConn1= new Node(1, "InetConn01");
    private static final Node inetConn2 = new Node(2, "InetConn02");
    private static final Node glasgowOffice = new Node(3, "Glasgow Office ");
    private static final Node newYorkOffice = new Node(4, "New York Office");
    private static final Node isolatedTestNetwork = new Node(5, "IsolatedTestNetwork ");
    private static final Node router1= new Node(6, "Router01");
    private static final Node isoPrinter= new Node(7, "IsoPrinter");
    private static final Node isoComp = new Node(8, "IsoComp");
    private static final Node phone = new Node(9, "Phone");
    private static final Node laptop = new Node(10, "Laptop");
    private static final Node hotDesk = new Node(11, "HotDesk");
    private static final Node iMac = new Node(12, "IMac");
    private static final Node pc = new Node(13, "PC");
    private static final Node glasLocalServer = new Node(14, "GlasLocalServer");
    private static final Node confPhone = new Node(15, "ConfPhone");

    public static void main() {
        graph.addEdge(cloudServ, inetConn1);
        graph.addEdge(cloudServ, inetConn2);

        graph.addEdge(inetConn1, glasgowOffice);
        graph.addEdge(inetConn1, router1);

        graph.addEdge(inetConn2, newYorkOffice);

        graph.addEdge(glasgowOffice, isolatedTestNetwork);

        graph.addEdge(isolatedTestNetwork, isoPrinter);
        graph.addEdge(isolatedTestNetwork, isoComp);

        graph.addEdge(router1, phone);
        graph.addEdge(router1, laptop);
        graph.addEdge(router1, hotDesk);
        graph.addEdge(router1, iMac);
        graph.addEdge(router1, pc);
        graph.addEdge(router1, glasLocalServer);
        graph.addEdge(router1, confPhone);
    }
}

package cloud.cluster.sim;


import cloud.cluster.sim.requestsimulator.simulators.SimulationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Client implements CommandLineRunner {

    @Autowired
    SimulationController sc;

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main (String[] args) {
        SpringApplication.run(Client.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("<-----------------------Start---------------------->");
        sc.startSimulation();
        logger.info(" <-----------------------End---------------------->");
    }

}

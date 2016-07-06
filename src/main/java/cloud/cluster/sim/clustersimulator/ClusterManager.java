package cloud.cluster.sim.clustersimulator;

import cloud.cluster.sim.clustersimulator.dto.TCGroup;
import cloud.cluster.sim.utilities.SimSettingsExtractor;
import cloud.cluster.sim.clustersimulator.dto.Cluster;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Implements operations on the Cluster.
 */
@Component
public class ClusterManager {

    private long rpsForOneVm;
    private Cluster cluster;
    private static final Logger logger = LoggerFactory.getLogger(ClusterManager.class);

    /**
     * Read Cluster configuration date from Json file.
     */
    public ClusterManager() {
        this. rpsForOneVm = SimSettingsExtractor.getSimulationSettings().getRpsForVm();

        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("clusterConfiguration.json").getFile();

        ObjectMapper mapper = new ObjectMapper();

        try {
            cluster = mapper.readValue(new File(path), Cluster.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Return the Cluster used by the ClusterManager.
     *
     * @return Cluster used by the ClusterManager.
     */
    public Cluster getCluster() {
        return cluster;
    }

    public long getRpsForOneVm() {
        return rpsForOneVm;
    }

    /**
     * Compute the maximum RPS supported by the Cluster managed by the ClusterManager.
     *
     * @return maximum number of request that can be fulfilled by the Cluster in one second.
     */
    public long computeMaxRps() {
        return cluster.getTgGroup()
                .stream()
                .mapToLong(TCGroup::getVmNumber)
                .sum() * rpsForOneVm;
    }

}
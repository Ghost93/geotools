package org.geotools.geojson;

import com.vividsolutions.jts.geom.Geometry;
import junit.framework.TestCase;
import org.geotools.geojson.geom.GeometryJSON;

import java.io.IOException;


public class GEOT4100RegressionTest extends TestCase {

    private static final String FEATURE_WTTH_LINESTRING_AND_2_PROPERTIES = "{\"type\":\"Feature\",\"geometry\":{\"type\":\"LineString\",\"coordinates\":[[102.0,0.0],[103.0,1.0],[104.0,0.0],[105.0,1.0]]},\"properties\":{\"prop0\":\"value0\",\"prop1\":0.0}}";
    private static final String SIMPLE_POLYGON = "{\"type\":\"Polygon\",\"coordinates\":[[[100.0,0.0],[101.0,0.0],[101.0,1.0],[100.0,1.0],[100.0,0.0]]]}";

    public void testFeatureIsReadToGeoJson() throws IOException {
        GeometryJSON geometryJSON = new GeometryJSON();
        final Geometry geometry = geometryJSON.read(FEATURE_WTTH_LINESTRING_AND_2_PROPERTIES);
        assertEquals("LineString", geometry.getGeometryType());
    }

    /*public void testGeoJsonFReadToFeatureJSON() throws IOException {
        FeatureJSON featureJSON = new FeatureJSON();
        final SimpleFeature simpleFeature = featureJSON.readFeature(SIMPLE_POLYGON);
        assertNotNull(simpleFeature.getDefaultGeometry());
        StringWriter sw = new StringWriter();
        GeometryJSON geometryJSON = new GeometryJSON();
        geometryJSON.write((Geometry) simpleFeature.getDefaultGeometry(), sw);
        System.out.println(sw.toString());
        assertEquals(0, simpleFeature.getAttributeCount());
    }*/
}

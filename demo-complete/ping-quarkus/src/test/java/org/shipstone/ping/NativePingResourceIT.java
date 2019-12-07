package org.shipstone.ping;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativePingResourceIT extends PingResourceTest {

    // Execute the same tests but in native mode.
}

# hetzner-dns-api: A Java library for the Hetzner DNS API

hetzner-dns-api is a Java library for the [Hetzner DNS API](https://dns.hetzner.com/api-docs/) using OpenFeign.

## Example

```java
package com.custom.app;

import com.nl2go.hetzner.dns.service.HetznerDnsApiService;

public class CustomApp {

    @Autowired
    private HetznerDnsApiService hetznerDNSApiService;

    public void getHetznerDNSZones() {
        List<Zone> zones = hetznerDNSApiService.getZones();
    }
}
```



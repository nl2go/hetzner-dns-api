# hetzner-dns-api: A Java library for the Hetzner DNS API

[![Build status](https://travis-ci.com/nl2go/hetzner-dns-api.svg?branch=master)](https://travis-ci.com/nl2go/hetzner-dns-api)
[![codecov](https://codecov.io/gh/nl2go/hetzner-dns-api/branch/master/graph/badge.svg)](https://codecov.io/gh/nl2go/hetzner-dns-api)

hetzner-dns-api is a Java library for the [Hetzner DNS API](https://dns.hetzner.com/api-docs/) using OpenFeign.

## Example

```java
package com.custom.app;

import com.nl2go.hetzner.dns.model.Zone;
import com.nl2go.hetzner.dns.service.HetznerDnsApiService;

public class CustomApp {

    @Autowired
    private HetznerDnsApiService hetznerDNSApiService;

    public void getHetznerDNSZones() {
        List<Zone> zones = hetznerDNSApiService.getZones();
    }
}
```

Required configuration:

```yaml
hetzner-dns-api:
  token: YourToken
  url: https://dns.hetzner.com/api/v1/
```



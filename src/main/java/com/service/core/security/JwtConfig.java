package com.service.core.security;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" +
			"MIIEpgIBAAKCAQEAzIlUvFs9ygmf9CylZRXLMcHfAE7LLFUABtie2EHTw6IrAM/L\n" +
			"/XV4H6p895nB7SXoLPO6J2ksOzRcSCPv4P3iXVW6iDNz99cb+1JDwRlOoY7WAM3L\n" +
			"kgjLyo5zLnT4LrtrsBHz0ERmS59uhReUKNakkc90MdAY/QBfbk2IjaCY2iAywtEo\n" +
			"oJ+D0VuOFzzpSsxFyTcWJQTNMGQyGqbNEQybooJL3Ha/8TxYEZpIJuvwM8jPkCUX\n" +
			"KvQeAVW4i4vRL0oXsXwxErLUFIpW9jHsC7KrYOqt411m4m+2z1/D2ReSt/eLo2Lb\n" +
			"hDhtdT9FcyIAbPdvMdsjq6HfXkIQ1/KSPt6pcwIDAQABAoIBAQCyrfYcZgjgiu/1\n" +
			"O1txp0xPN3I8rpjHLapMUMjTWw5IBU9T8jPeQ9SgtSteki/boBXnzzN8YmCFiARl\n" +
			"8R8JikFKEC5X9bsFdCG5t/AArL8IW+OP6DhCZvTBCxiMKRr2mDxHICfCdT54Kds+\n" +
			"4Y5I7tntlzGGoqhxvPWhQpJcR0PAqHglMlWpoH0O+7C3wmWYakI9BFvif0IT4+dt\n" +
			"C3bwFsLaT9xVBluPDB/5dOVqwKwCRwJAaKCUq25evsJLOsbEbTwM0FJd4eIMlpaW\n" +
			"Ud9o43LgcvpUhyu7dMQcExlZRqUsn05MSLHX6q2eQGmF9ilBbWM3jj+T66Bja8s5\n" +
			"QN/6+NChAoGBAOzc3xStnnHbA/e4dGGJRdsIF2N08q7FS88sSPF1hShz4ysHH1gn\n" +
			"vlqTLHM7+vs/JK+ZnxRWlIna4aHD8qczj3HI5xeUH9IfyJJOPvsZB6tJFnOIhpBm\n" +
			"KHsU9j2BjQfCMguGXfxNkiOgdugjkwvdcAYMUTHq/LlicVi1jh6xVeQNAoGBAN0P\n" +
			"107UX77rslv+Sw4aD4SaSDSUcOSvyTDmcrsOq6fVTjNuQNlIyX2e9aBDbleVNOiJ\n" +
			"kWZgWQ3/JzqYm3+EV1NtgiBaTPeNqPtrHgCoQAa2F65PmaYzKKHxJXsN57wmPW4I\n" +
			"WPYtGKAuCrQ+Q6Q8uTzf/f3VagQzmbVgD/QCd+N/AoGBALhssXWUSY41Db3P7S4U\n" +
			"iEOm5S8XW+4gyIoi3RjEfE2nDfXuscUeDOTROwbuaNk/rPzdDDP1xeogdxZRT5pI\n" +
			"VyQtXWHKf4xIGw9vxTIVpxcC7Ww/nSbJpDNRevkg6gJkfjrjAEL20xbSVkMhj9jp\n" +
			"LdRHuuC3KtfdgoujsWjMgyfxAoGBANF3GCoO3GaZCVlX3KCRGxEn67E+0rYuxvH5\n" +
			"+s66ePbADKh5GSOKb7oDrHTeUCjXLdoFuGuMcfXsRqykO/uZV/GqeznStsl/RpZt\n" +
			"CnHO+1QgqNG3hTzRjvfb+wrdwy4qAd1INZuWYZYt6mCd+xQdodxH1nD2Ds3KYyRU\n" +
			"0OkCib1bAoGBANy9E1u4KmUWJcLhJZMm5C8u7HRCEnzfWJVSGGpQ5AgpJW20wLNH\n" +
			"xz/4qNKhFta64oOIuBE9aLv1k6iWt2V97l+EdoVpQEGpS90TLVWyCQC2FUX1bxFo\n" +
			"e9jp1st7LIa8D4fFMPPQ+wNRTz0WjTIpfnnYQ6BCWYbEKkraHaLjOdtb\n" +
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzIlUvFs9ygmf9CylZRXL\n" +
			"McHfAE7LLFUABtie2EHTw6IrAM/L/XV4H6p895nB7SXoLPO6J2ksOzRcSCPv4P3i\n" +
			"XVW6iDNz99cb+1JDwRlOoY7WAM3LkgjLyo5zLnT4LrtrsBHz0ERmS59uhReUKNak\n" +
			"kc90MdAY/QBfbk2IjaCY2iAywtEooJ+D0VuOFzzpSsxFyTcWJQTNMGQyGqbNEQyb\n" +
			"ooJL3Ha/8TxYEZpIJuvwM8jPkCUXKvQeAVW4i4vRL0oXsXwxErLUFIpW9jHsC7Kr\n" +
			"YOqt411m4m+2z1/D2ReSt/eLo2LbhDhtdT9FcyIAbPdvMdsjq6HfXkIQ1/KSPt6p\n" +
			"cwIDAQAB\n" +
			"-----END PUBLIC KEY-----";

}

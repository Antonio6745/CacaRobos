package br.sp.cacarobos.model;

public enum SocialNetworkType {
	FACEBOOK("Facebook"),INSTAGRAM("Instagram"),TWITTER("Twitter"),GOOGLE_PLUS("Google +");
	public String socialNetworkType;
	private SocialNetworkType(String socialNetworkType) {
		this.socialNetworkType=socialNetworkType;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}

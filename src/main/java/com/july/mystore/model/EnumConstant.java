package com.july.mystore.model;

public class EnumConstant {
	public enum Role {
		USER(1101), ADMIN(1102);
		
		public int value;
		
		private Role(int value) {
			this.value = value;
		}
	}
	
	public enum Condition {
		NEW(1), OLD(2), REFURBISHED(3);
		
		public int value;
		
		private Condition(int value) {
			this.value = value;
		}
	}
	
}

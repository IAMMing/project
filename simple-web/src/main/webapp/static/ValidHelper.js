function ValidHelper(date) {
	
	//私有变量
	this.period = 10;
	this.invalid = 0;
	this.currentDate = null;

	if(typeof date === 'string' || typeof date === 'number') {
		try {
			this.currentDate = new Date(date);
		}
		catch(err) {
			this.currentDate = new Date();
		}
	}
	else if(typeof date === 'object') {
		try {
			this.currentDate = new Date(date.toString());
		}
		catch(err) {
			this.currentDate = new Date();
		}
	}
	else {
		this.currentDate = new Date();
	}
}
ValidHelper.prototype = {
	constructor: ValidHelper,
	getPeriod: function() {
		return this.period;
	},
	setPeriod: function(period) {
		this.period = period;
	},
	getInvalid: function() {
		return this.invalid;
	},
	setInvalid:  function(invalid) {
		this.invalid = invalid;
	},
	getValidString: function(encry) {
		var data={v:this.getValidStamp(),t:this.getTimeStamp(),c:0,n:0};
		console.log(data);
		return data;
		if(this.isValid()) {
			console.log("验证客户端...");
			var stamp = this.getTimeString();
			console.log("服务端明文：" + stamp);
			var encryStamp = hex_md5(stamp);
			console.log("服务端密文：" + encryStamp);
			return encry === encryStamp;
		}
		return true;
	},
	getValidStamp:function(){
		var stamp=this.getTimeString();
		return hex_md5(stamp);
	},
	getTimeString: function() {
		var sbDate = [];
		sbDate.push(this.currentDate.getFullYear());
		sbDate.push(this.currentDate.getMonth() + 1);
		sbDate.push(this.currentDate.getDate());
		sbDate.push(this.currentDate.getHours());
		var min = this.currentDate.getMinutes();

		sbDate.push(this.getValidMinute(min));
		return sbDate.join("");
	},
	getTimeStamp:function ()
	{
		return this.currentDate.valueOf();
	},
	getValidMinute: function(minute) {
		return parseInt(minute / this.period) * this.period;
	},
	isValid: function(minute) {
		if(minute !== undefined) {
			var validMinute = this.getValidMinute(minute);
			return Math.abs(minute - validMinute) > this.invalid;
		}
		else {
			minute = this.currentDate.getMinutes();
			return this.isValid(minute);
		}
	}
};
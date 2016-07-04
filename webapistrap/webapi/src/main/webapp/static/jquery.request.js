(function($){
	$.fn.test=function(data)
	{
		alert(data);
	}
})(jQuery);
jQuery.request=function(data)
{
	
	var v=new ValidHelper();
	var params=v.getValidString();
	var params_r=jQuery.extend({},params,{r:data.data['r']});
	delete data.data['r'];
	var data_r={param:'#'+JSON.stringify(data.data)+'#'};
	var rp=jQuery.extend({},params_r,data_r);
	data.data=rp;
	console.log(rp);
	jQuery.ajax(data);
}
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
	var data={param:data.data};
	var rp=jQuery.extend({},params,data);
	data.data=rp;
	jQuery.ajax(data);
}
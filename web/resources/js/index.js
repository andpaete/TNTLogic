// add to footer
$("#menu-toggle").click(function(e){
	e.preventDefault();
	$("#wrapper").toggleClass("toggled");
	$("#c-mask").toggleClass("is-active");
	$('body').toggleClass("has-active-menu");
});

$("#c-mask").click(function(e){
	e.preventDefault();
	$("#wrapper").removeClass("toggled");
	$("#c-mask").removeClass("is-active");
	$('body').removeClass("has-active-menu");
});
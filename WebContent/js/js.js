String.format = function (s) {var a = Array.prototype.splice.call(arguments, 1);return s.replace(/{(\d+)}/g, function (m, i) {return a[i];});};
HTMLElement.prototype.append = function(s) {
	this.insertAdjacentHTML('beforeend', s);
};
function $(n){
	return document.getElementsByClassName(n);
}
HTMLCollection.prototype.click = function(f) {
	for(var i = this.length - 1; i >= 0; i--){
		this[i].onclick = f;
	}
};
HTMLInputElement.prototype.val = function(v) {
	if(v === undefined){
		return this.value;
	}else{
		this.value = v;
	}
};
HTMLElement.prototype.parent = function(t) {
	var n = this;
	while(n != null && n.tagName.toLowerCase() != t){
		n = n.parentNode;
	}
	return n;
};
HTMLElement.prototype.text = function() {
	return this.innerText;
};
NodeList.prototype.find = function(v) {
	for(var i = this.length - 1; i >= 0; i--){
		
		if(this[i].val() === v){
			return this[i];
		}
	}
	return null;
};
HTMLElement.prototype.remove = function(c) {
	this.removeChild(c);
};
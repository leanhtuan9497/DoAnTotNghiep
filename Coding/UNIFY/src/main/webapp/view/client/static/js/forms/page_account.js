var Account = function() {
	return {
		checkRef: function() {
			if (document.getElementById("referalCode").value === '') {
				document.getElementById("referalCode").disabled = false;
			}
			else
				document.getElementById("referalCode").disabled = true;
		}
	}

}
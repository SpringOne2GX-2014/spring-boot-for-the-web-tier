yieldUnescaped '<!DOCTYPE html>'
html {
	head {
		title('SpringOne 2014')
		yieldUnescaped '<script src="/webjars/jquery/2.1.1/jquery.js"></script>'
		yieldUnescaped '<script src="/js/jquery.lettering.js"></script>'
		link(rel: 'stylesheet', href: '/css/page.css')
		link(rel: 'stylesheet', href: '/wro.css')
	}
	body {
		h1(spring.getMessage('hello','Hello') + " $name")
		div(class: 'container') {
			div(class: 'os-phrases') {
				items.each {
					h2("$it")
				}
			}
		}
		script {
			yieldUnescaped '$(document).ready(function() {$(".os-phrases > h2").lettering("words").children("span").lettering().children("span").lettering();})';
		}
	}
}






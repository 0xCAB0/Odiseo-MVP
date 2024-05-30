asdf.install:
	apt install curl git
	git clone https://github.com/asdf-vm/asdf.git ~/.asdf --branch v0.14.0
	. "$(HOME)/.asdf/asdf.sh"

asdf.install_plugins:
	$(call check-program, asdf)
	@echo "Installing asdf plugins..."
	@set -e; \
	for PLUGIN in $$(cut -d' ' -f1 .tool-versions | grep "^[^\#]"); do \
		asdf plugin add $$PLUGIN || [ $$?==2 ] || exit 1; \
	done

asdf.install_tools: asdf.install_plugins
	$(call check-program, asdf)
	@echo "Installing asdf tools..."
	@asdf install


tidy:
	$(call check-program, go)
	go mod tidy
	cd js; go mod tidy
	cd tool/tyber/go; go mod tidy
.PHONY: tidy
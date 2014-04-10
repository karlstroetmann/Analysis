open: analysis.pdf
	open analysis.pdf

%.pdf: %.ps
	ps2pdf $<

%.ps:  %.dvi
	dvips -o $@ $<

analysis.dvi:   analysis.tex folgen-und-reihen.tex stetige-funktionen.tex fourier.tex \
                anwendungen.tex integration.tex
	latex analysis.tex
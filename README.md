This provides a solution to the Guilded Rose Kata. A description of the kata is available 
[here.](http://craftsmanship.sv.cmu.edu/exercises/gilded-rose-kata)

I started out with a minimal modification to the GuildedRose class - basically extracting the code called in
the loop inside updateQuality to call a method in which the original logic was embedded. I then wrote a set of unit
tests to position myself to be able to start cleaning up the GildedRose small change by small change.

After making a clean up pass I was not satisfied with the result: even though there were small easy to read functions 
there was too much going on in the class.

Based on how different algorithms were applied based on context for determining quality and sell in, as well as differing
algorithms for adjusting quality past the sell by date, I decided to apply the strategy pattern. This let me collect
together the different algorithms into classes based on item context.

In applying the strategy refactoring, I built and tested some scaffolding (StrategyTests) to validate the basic approach.
I think gutted the GildedRose class and fleshed out the remaining strategy classes one failing test at a time until
I had achieved all green.

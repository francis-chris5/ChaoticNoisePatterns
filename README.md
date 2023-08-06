# ChaoticNoisePatterns
A noise generator that uses some well known non-linear dynamic (a.k.a. "Chaos") equations to generate the noise instead of random patterns.
---
I needed a noise pattern that came in perfectly straight lines for a project (trying to make some log cabin models in Blender for a video game) but none of the noise generators I could find would give straight lines with smooth transitions, so I made my own (in Java since I'm teaching a class on Java in two weeks). It worked for my needs, but I doubt this project goes much further as it would generally make more sense to just apply this logic directly in Blender to have the noise pattern generator there.

Thsi uses the Spring Boot framework to make a web app, some input options on a website feed into the noise generation on the back end and a REST-API call from the javascript loads a preview on the webpage -I just right-clicked and "save image as"- along with a collection of grayscale percentages for each pixel.

![Screenshot 2023-08-06 063747](https://github.com/francis-chris5/ChaoticNoisePatterns/assets/50467171/a0926484-2fab-4629-a222-8902db7151fb)
![Screenshot 2023-08-06 063741](https://github.com/francis-chris5/ChaoticNoisePatterns/assets/50467171/735b367a-364f-4413-b989-6d54f98f7f76)
![Screenshot 2023-08-06 070957](https://github.com/francis-chris5/ChaoticNoisePatterns/assets/50467171/f09f604d-0cd8-47da-b575-0976b68377e0)


---
layout: post
title:  "Midjourney prompts cheatsheet - Commands, properties, image hacks and more"
author: Pramod
categories: [ ChatGPT, Midjourney ]
image: assets/images/midjourney-series-tipseason.png
beforetoc: "Master the art of AI image generation with Midjourney commands cheatsheet. Incudes commands, properties, image prompt techniques, master guide"
featured: true
toc: true
tableofcontents: true
promote: true
---

## Midjourney Cheatsheet Introduction: 

Generative art, using AI tools like Midjourney, DALL-E, and Stable Diffusion, has become the go-to resource for many of
us in our creative journeys.

In the previous tutorial we learnt about how to generate best midjourney prompts using ChatGPT. In case you missed it
you can get it here [50+ Chatgpt prompts for Midjourney - Generative AI art](/chatgpt-prompts-for-midjourney/)

Midjourney prompt engineering has become a key skill for AI generate art as a freelance artist or professional designer.
Whether you're an AI enthusiast or a creative professional looking to try something new, join us as we explore the
exciting possibilities of all in one midjourney prompts cheatsheet - the ultimate resource for anyone looking to
overcome creative blocks and stay inspired.

Packed with commands, properties, image hacks, and more, this cheatsheet is your secret weapon for unleashing your
creativity and pushing past any obstacle. Whether you're a writer, artist, or designer, this cheatsheet will help you
stay on track and bring your vision to life.


Before jumping into the cheatsheet, don't miss out this.  

<a href="https://etsy.me/3Zy9Knu"><img src="/assets/images/chatgpt-prompts-ai-tools-1000.jpg" alt="chatgpt prompts and ai tools download" style="width:80%;"></a>


Use this cheatsheet as a reference when you engineer your midjourney prompts.

Let's get started!!

## Midjourney Commands List Cheatsheet
Here are the commands that you  can run using the `/` tag. 

<table class="table table-striped" >
  <tr>
    <th>Command</th>
    <th>Description</th>
  </tr>
  <tr>
    <td class="text text-danger">/imagine</td>
    <td class="text">Generate an image using a prompt.</td>
  </tr>
  <tr>
    <td class="text text-danger">/ask</td>
    <td class="text">Get an answer to a question.</td>
  </tr>
  <tr>
    <td class="text text-danger">/blend</td>
    <td class="text">Easily blend two images together.</td>
  </tr>
  <tr>
    <td class="text text-danger">/daily_theme</td>
    <td class="text">Toggle notification pings for the #daily-theme channel update.</td>
  </tr>
  <tr>
    <td class="text text-danger">/fast</td>
    <td class="text">Switch to Fast mode.</td>
  </tr>
  <tr>
    <td class="text text-danger">/help</td>
    <td class="text">Shows helpful basic information and tips about the Midjourney Bot.</td>
  </tr>
  
  <tr>
    <td class="text text-danger">/info</td>
    <td class="text">View information about your account and any queued or running jobs.</td>
  </tr>
  <tr>
    <td class="text text-danger">/stealth</td>
    <td class="text">For Pro Plan Subscribers: switch to Stealth Mode.</td>
  </tr>
  <tr>
    <td class="text text-danger">/public</td>
    <td class="text">For Pro Plan Subscribers: switch to Public Mode.</td>
  </tr>
  <tr>
    <td class="text text-danger">/subscribe</td>
    <td class="text">Generate a personal link for a user's account page.</td>
  </tr>
  <tr>
    <td class="text text-danger">/settings</td>
    <td class="text">View and adjust the Midjourney Bot's settings.</td>
  </tr>
  <tr>
    <td class="text text-danger">/prefer option</td>
    <td class="text">Create or manage a custom option.</td>
  </tr>
  <tr>
    <td class="text text-danger">/prefer option list</td>
    <td class="text">View your current custom options.</td>
  </tr>
  <tr>
    <td class="text text-danger">/prefer suffix</td>
    <td class="text">Specify a suffix to add to the end of every prompt.</td>
  </tr>
  <tr>
    <td class="text text-danger">/show</td>
    <td class="text">Use an images Job ID to regenerate within Discord.</td>
  </tr>
  <tr>
    <td class="text text-danger">/relax</td>
    <td class="text">Switch to Relax mode.</td>
  </tr>
  <tr>
    <td class="text text-danger">/remix</td>
    <td class="text">Toggle Remix mode.</td>
  </tr>
</table>

<br>

## Midjourney Parameter List Cheatsheet

### Basic Parameters
- `--aspect` or `--ar`: Change the aspect ratio of a generation. Eg: `--ar 2:3`
    - `--ar 1:1` Default aspect ratio.
    - `--ar 5:4` Common frame and print ratio.
    - `--ar 3:2` Common in print photography.
    - `--ar 7:4` Close to HD TV screens and smartphone screens.
- `--chaos <number 0–100>`: Change how varied the results will be. Higher values produce more unusual and unexpected generations.
- `--no`: Negative prompting, remove plants from the image.
- `--quality <.25, .5, 1, or 2>` or `--q <.25, .5, 1, or 2>`: How much rendering quality time you want to spend. The default value is 1. Higher values cost more and lower values cost less.
- `--seed <integer between 0–4294967295>`: The Midjourney bot uses a seed number to create a field of visual noise, like television static, as a starting point to generate the initial image grids. Seed numbers are generated randomly for each image but can be specified with the `--seed` or `--sameseed` parameter. Using the same seed number and prompt will produce similar ending images.
- `--stop <integer between 10–100>`: Use the `--stop` parameter to finish a Job partway through the process. Stopping a Job at an earlier percentage can create blurrier, less detailed results.
- `--style <4a, 4b or 4c>`: Switch between versions of the Midjourney Model Version 4
- `--stylize <number>` or `--s <number>`: Parameter influences how strongly Midjourney's default aesthetic style is applied to Jobs.
- `--uplight`: Use an alternative "light" upscaler when selecting the U buttons. The results are closer to the original grid image. The upscaled image is less detailed and smoother.
- `--upbeta`: Use an alternative beta upscaler when selecting the U buttons. The results are closer to the original grid image. The upscaled image has significantly fewer added details.

### Model Version Parameters
- `--niji`: An alternative model focused on anime style images.
- `--hd`: Use an early alternative Model that produces larger, less consistent images. This algorithm may be suitable for abstract and landscape images.
- `--test`: Use the Midjourney special test model.
- `--testp`: Use the Midjourney special photography-focused test model.
- `--version <1, 2, 3, 4 or 5>` or `--v <1 2, 3, 4 or 5>`: Use an earlier version of the Midjourney algorithm. The current algorithm (V5) is the default setting.

### Upscaler Parameters
- `--uplight`: Use an alternative "light" upscaler when selecting the U buttons. The results are closer to the original grid image. The upscaled image is less detailed and smoother.
- `--upbeta`: Use an alternative beta upscaler when selecting the U buttons. The results are closer to the original grid image. The upscaled image has significantly fewer added details.
- `--upanime`: Use an alternative upscaler trained to work with the `--niji` Midjourney Model.

### Other Parameters
- `--creative`: Modify the test and testp models to be more varied and creative.
- `--iw`: Sets image prompt weight relative to text weight. The default value is `--iw 0.25`.
- `--sameseed`: Seed values create a single large random noise field applied across all images in the initial grid. When `--sameseed` is specified, all images



## Image Generation Cheatsheet

Here are some common styles of image generation and their characteristics:

<table class="table table-striped">
  <thead>
    <tr>
      <th>Style</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class="text text-danger">8k</td>
      <td>Lighting tends to be more extreme; colors even more saturated and computer-generated looking than "high definition"</td>
    </tr>
    <tr>
      <td class="text text-danger">cinematic</td>
      <td>Shadows tend to be more extreme (though not darker); objects a bit thicker; more poster-like</td>
    </tr>
    <tr>
      <td class="text text-danger">high definition</td>
      <td>Shadows are lightened; more fanciful and saturated colors</td>
    </tr>
    <tr>
      <td class="text text-danger">ultra photorealistic</td>
      <td>Similar to "fine ultra-detailed realistic"</td>
    </tr>
    <tr>
      <td class="text text-danger">Hasselblad H6D</td>
      <td>Sharper focus on subject; shadows are deepened</td>
    </tr>
    <tr>
      <td class="text text-danger">fine ultra-detailed realistic</td>
      <td>Can be a bit grainy and "ropey" but increases detail generation</td>
    </tr>
    <tr>
      <td class="text text-danger">color grading</td>
      <td>Extreme variations in hue; vibrant but not over-saturated colors</td>
    </tr>
    <tr>
      <td class="text text-danger">depth of field</td>
      <td>Sharp focus on subject, background and foreground blurred</td>
    </tr>
    <tr>
      <td class="text text-danger">film lighting</td>
      <td>Limited lighting sources; backlighting common; deep shadows cast by light sources</td>
    </tr>
    <tr>
      <td class="text text-danger">rim lighting</td>
      <td>Slightly stronger lighting effect than "film lighting," but very similar results</td>
    </tr>
    <tr>
      <td class="text text-danger">intricate</td>
      <td>Tends toward non-realistic "crafts" and "pattern" type designs.</td>
    </tr>
    <tr>
      <td class="text text-danger">realism</td>
      <td>Artistic realism. Backgrounds tend to be more uniform; subject looks more like a painting; more objects with subject</td>
    </tr>
    <tr>
      <td class="text text-danger">photography</td>
      <td>Subject tends to have a little area of objects around it with little else in the background</td>
    </tr>
    <tr>
      <td class="text text-danger">rendered for IMAX</td>
      <td>More complex subject with very directional lighting and subdued saturation</td>
    </tr>
    <tr>
      <td class="text text-danger">tilt-shift</td>
      <td>Like "depth of field," but from above or with high angle</td>
    </tr>
    <tr>
      <td class="text text-danger">motion-blur</td>
      <td>Speed lines. May render as if wind is blowing</td>
    </tr>
    <tr>
      <td class="text text-danger">35mm film</td>
      <td>More vibrant colors, but muted saturation, detailed with additional foreground and/or background elements</td>
    </tr>
    </tbody>
</table>

## Conclusion: 

In conclusion, generative art and AI tools like Midjourney, DALL-E, and Stable Diffusion can be powerful resources for
anyone looking to push past creative blocks and generate fresh ideas. By leveraging the capabilities of these tools, you
can create stunning visuals, explore new possibilities, and take your project to new heights. We hope this blog post has
inspired you to try new things and explore the exciting possibilities of generative art and AI tools in your creative
journey.

If you enjoyed this post, we encourage you to share it with your friends and followers on social media and following us
on twitter @thetipseason And if you want to stay up-to-date on the latest trends in generative art and AI, be sure to
follow our newsletter for more tips, tricks, and insights. Thanks for reading, and happy creating!


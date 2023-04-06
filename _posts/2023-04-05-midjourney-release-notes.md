---
layout: post
title:  "Midjourney update log (Release notes)"
author: Pramod
categories: [ ChatGPT, Midjourney ]
image: assets/images/midjourney-series-tipseason.png
beforetoc: "Master the art of using midjourney, stable difussion or DALL-E-2 with creative realistic photo like images."
featured: true
toc: true
tableofcontents: true
---

This page will track all the latest announcements and updates provided by Midjourney. Its a release notes tracker to
keep track of latest updates from midjourney. These announcements are taken directly from official midjourney discord channel. 

This is a great way to keep track of trending ai news and latest releases from web. 

# April 5, 2023

## Highlights: [Midjourney repeat and permutations feature](/midjourney-repeat-permutations/)

Midjourney is going to launch two new advanced prompting features today

These features generate TONS of jobs and can use TONS of GPUs so they're limited right now to Pro Members (the 60$/mo plan) and fast-hours only

### Introducing the Repeat feature
- Type --repeat with a number are your job to run that job that many times
- For example /imagine cats --repeat 5 will create five 2x2 grids of cats
- Try mixing this with other arguments like --chaos  to radically increase your pace of exploration

### Introducing the Permutations Feature
- This feature lets you create large numbers of jobs with different combinations of words

A simple example of permutations
/imagine a {cyberpunk, vaporwave, art deco} {cat, dog}

This will generate all the following jobs
/imagine a cyberpunk cat
/imagine a vaporwave cat
/imagine a art deco cat
/imagine a cyberpunk dog
/imagine a vaporwave dog
/imagine a art deco dog

🐦 You can even nest { } inside other { } if you are careful
/imagine A {sculpture, painting} of a {seagull {on a pier, on a beach}, poodle {on a sofa, in a truck}}.

/imagine A sculpture of a seagull on a pier.
/imagine A sculpture of a seagull on a beach.
/imagine A sculpture of a poodle on a sofa.
/imagine A sculpture of a poodle in a truck.
/imagine A painting of a seagull on a pier.  
/imagine A painting of a seagull on a beach.  
/imagine A painting of a poodle on a sofa.  
/imagine A painting of a poodle in a truck.

Please note: All of these 'batch' operations are limited to 40 jobs (past that and it will discard them) and will process up to 16 at a time.

You can find more documentation here: ❓Q - What are {permutations}? H…

We know these are kinda power features, but we know they'll be super fun for a lot of people and we hope you enjoy!  Please give us feedback on the ideas-and-features 

<hr>

<a href="https://etsy.me/3ljbdQ3"><img src="/assets/images/chatgpt-prompts-ai-tools-1000.jpg" alt="chatgpt prompts and ai tools download" class="img-fluid"></a>


# April 3, 2023

## Highlights: [Midjourney describe feature](/midjourney-describe-feature/) 

Introducing /describe for image2text on Midjourney
- Use the /describe command and upload an image to get 4 text prompts that try to describe the image
- Click buttons underneath the command to generate images for each of the prompts

Let us know what you think in #ideas-and-features  or feel free to share your wacky and interesting /describe results in #describe-show 

<hr>

# March 29, 2023 

## Highlights: New version of v5 algorithm

Deployed a new version of our v5 algorithms tonight. It is now live and default any time you use --v 5

Changes
- The new algorithm should be twice as fast
- This also means half the cost (in terms of fast hours)
- There should be little or no loss in quality
- This should also solve all the gpu shortages

If you think you sense a problem
- You can fall back to the old model with --v 5a
- Double check with the same --seed (use fast mode for both images)
- Let us know in ideas-and-features 
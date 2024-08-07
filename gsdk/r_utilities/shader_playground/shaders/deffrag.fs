#version 330

in vec2 fragTexCoord;
in vec4 fragColor;

out vec4 finalColor;

uniform sampler2D texture0;

uniform vec4 colDiffuse;

void main() {
    finalColor = texture(texture0, fragTexCoord) * colDiffuse * fragColor;
}
